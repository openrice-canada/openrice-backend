package ca.openricecan.service.auth;

import ca.openricecan.model.dto.user.AuthenticationRequest;
import ca.openricecan.model.dto.user.AuthenticationResponse;
import ca.openricecan.model.dto.user.RegisterRequest;
import ca.openricecan.model.utils.user.Role;
import ca.openricecan.model.entity.user.UserEntity;
import ca.openricecan.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            return AuthenticationResponse.builder()
                    .message("Email already exists")
                    .build();
        } else if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            return AuthenticationResponse.builder()
                    .message("Username already exists")
                    .build();
        }
        var user = UserEntity.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        var user = userRepository.findByEmail(request.getEmailOrUsername())
                .orElse(userRepository.findByUsername(request.getEmailOrUsername()).orElse(null));
        if (user == null || !user.isAccountNonExpired()) {
            return AuthenticationResponse.builder()
                    .message("Sorry, we could not found your account")
                    .build();
        }
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmailOrUsername(),
                            request.getPassword()
                    )
            );
        } catch (BadCredentialsException badCredentialsException) {
            return AuthenticationResponse.builder()
                    .message("Password incorrect")
                    .build();
        }

        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
