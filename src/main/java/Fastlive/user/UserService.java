package Fastlive.user;

import Fastlive.user.dto.LoginRequest;
import Fastlive.user.dto.LoginResponse;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public LoginResponse login(LoginRequest request) {

        UserEntity user = userRepository.findByUsername(request.username())
                .orElseThrow(() -> new RuntimeException("Utilisateur introuvable"));

        if (!passwordEncoder.matches(request.password(), user.getPasswordHash())) {
            throw new RuntimeException("Mot de passe incorrect");
        }

        return new LoginResponse(
                user.getId(),
                user.getUsername(),
                user.getEmail()
        );
    }
}

