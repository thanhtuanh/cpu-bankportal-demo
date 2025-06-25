package com.bankportal_demo.authservice.service;

import com.bankportal_demo.authservice.dto.LoginRequest;
import com.bankportal_demo.authservice.dto.LoginResponse;
import com.bankportal_demo.authservice.model.User;
import com.bankportal_demo.authservice.model.UserEntity;
import com.bankportal_demo.authservice.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AuthServiceTest {

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
}