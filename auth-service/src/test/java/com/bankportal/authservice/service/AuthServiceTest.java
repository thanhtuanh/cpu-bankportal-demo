package com.bankportal.authservice.service;

import com.bankportal.authservice.dto.LoginRequest;
import com.bankportal.authservice.dto.LoginResponse;
import com.bankportal.authservice.model.User;
import com.bankportal.authservice.model.UserEntity;
import com.bankportal.authservice.repository.UserRepository;
import com.bankportal.authservice.service.AuthService;
import com.bankportal.authservice.service.JwtService;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class AuthServiceTest {

    UserRepository repo = mock(UserRepository.class);
    PasswordEncoder encoder = mock(PasswordEncoder.class);
    JwtService jwt = mock(JwtService.class);
    AuthService service = new AuthService(repo, encoder, jwt);

    @Test
    void loginBenutzerNichtGefunden() {
        LoginRequest req = new LoginRequest("u", "p");
        when(repo.findByUsername("u")).thenReturn(Optional.empty());
        assertThrows(BadCredentialsException.class, () -> service.login(req));
    }

    @Test
    void loginFalschesPasswort() {
        LoginRequest req = new LoginRequest("u", "p");
        UserEntity user = new UserEntity(1L, "u", "hash", null);
        when(repo.findByUsername("u")).thenReturn(Optional.of(user));
        when(encoder.matches("p", "hash")).thenReturn(false);
        assertThrows(BadCredentialsException.class, () -> service.login(req));
    }

    @Test
    void loginErfolgreich() {
        LoginRequest req = new LoginRequest("u", "p");
        UserEntity userEntity = new UserEntity(1L, "u", "hash", null);
        when(repo.findByUsername("u")).thenReturn(Optional.of(userEntity));
        when(encoder.matches("p", "hash")).thenReturn(true);
        when(jwt.generateToken("u")).thenReturn("jwtToken");
        LoginResponse resp = service.login(req);
        assertEquals("jwtToken", resp.getToken());
    }

    @Test
    void registerErfolgreich() {
        User user = new User(null, null, null);
        user.setId(null);
        user.setUsername("neuerUser");
        user.setPassword("plainPw");
        // user.setRole(null); // NICHT mehr nötig!

        when(repo.findByUsername("neuerUser")).thenReturn(Optional.empty());
        when(encoder.encode("plainPw")).thenReturn("hashedPW");
        when(repo.save(any(UserEntity.class))).thenAnswer(invocation -> {
            UserEntity saved = invocation.getArgument(0);
            saved.setId(42L);
            return saved;
        });

        UserEntity result = service.register(user);

        assertNotNull(result);
        assertEquals("neuerUser", result.getUsername());
        assertEquals("hashedPW", result.getPassword());
        assertEquals("ROLE_USER", result.getRole());
        assertEquals(42L, result.getId());
    }

   @Test
    void registerUserExistiertBereits() {
        User user = new User(null, "alice", "pw");
        user.setRole("ROLE_USER");
        UserEntity userEntity = new UserEntity(null, "alice", "pw", "ROLE_USER");
        when(repo.findByUsername("alice")).thenReturn(Optional.of(userEntity));
        assertThrows(BadCredentialsException.class, () -> service.register(user));
    }
}