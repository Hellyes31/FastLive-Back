package Fastlive.user;

import Fastlive.user.dto.LoginRequest;
import Fastlive.user.dto.LoginResponse;
import Fastlive.user.dto.RegisterRequest;
import Fastlive.user.dto.RegisterResponse;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;

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

    public RegisterResponse register(RegisterRequest request) {
        if(userRepository.findByUsername(request.username()).isPresent()){
            throw new RuntimeException("Nom d'utilisateur déjà utilisé");
        }

        if(userRepository.findByEmail(request.email()).isPresent()){
            throw new RuntimeException("Email déjà utilisé");
        }

        UserEntity user = new UserEntity();
        user.setUsername(request.username());
        user.setEmail(request.email());
        user.setPasswordHash(passwordEncoder.encode(request.password()));
        user.setCreatedAt(Instant.now());

        UserEntity savedUser = userRepository.save(user);

        return new RegisterResponse(
                savedUser.getId(),
                savedUser.getUsername(),
                savedUser.getEmail()
        );
    }
}

