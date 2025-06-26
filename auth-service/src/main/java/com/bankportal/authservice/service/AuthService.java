package com.bankportal.authservice.service;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bankportal.authservice.dto.LoginRequest;
import com.bankportal.authservice.dto.LoginResponse;
import com.bankportal.authservice.model.User;
import com.bankportal.authservice.model.UserEntity;
import com.bankportal.authservice.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class AuthService {

    private static final Logger log = LoggerFactory.getLogger(AuthService.class);

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public LoginResponse login(LoginRequest request) {
        // 1. Benutzer aus DB laden
        User user = userRepository.findByUsername(request.getUsername())
                .map(userEntity -> new User(userEntity.getId(), userEntity.getUsername(), userEntity.getPassword()))
                .orElseThrow(() -> new BadCredentialsException("Benutzer nicht gefunden: " + request.getUsername()));

        // 2. Debug-Log
        log.info("🔐 Benutzer gefunden: {}", user.getUsername());
        log.info("📝 Eingegebenes Passwort: {}", request.getPassword());
        log.info("🔒 Gespeicherter Hash: {}", user.getPassword());

        // 3. Passwort vergleichen
        boolean match = passwordEncoder.matches(request.getPassword(), user.getPassword());
        log.info("✅ Passwortvergleich erfolgreich? {}", match);

        if (!match) {
            throw new BadCredentialsException("❌ Passwort ungültig für Benutzer: " + user.getUsername());
        }

        // 4. JWT erzeugen
        String token = jwtService.generateToken(user.getUsername());
        log.info("🎫 JWT generiert für {}: {}", user.getUsername(), token);

        // 5. Antwort zurückgeben
        return new LoginResponse(token);
    }

    public UserEntity register(User user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new BadCredentialsException("Benutzername bereits vergeben: " + user.getUsername());
        }

        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);

        // Setze die Rolle IMMER explizit:
        user.setRole("ROLE_USER");

        UserEntity userEntity = new UserEntity(user.getId(), user.getUsername(), hashedPassword, user.getRole());
        userRepository.save(userEntity);
        log.info("✅ Benutzer registriert: {}", user.getUsername());
        return userEntity;
    }
}
