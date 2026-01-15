package Fastlive.user;

import Fastlive.user.dto.LoginRequest;
import Fastlive.user.dto.LoginResponse;
import Fastlive.user.dto.RegisterRequest;
import Fastlive.user.dto.RegisterResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return userService.login(request);
    }

    @PostMapping("/register")
    public RegisterResponse register(@RequestBody RegisterRequest request){
        return userService.register(request);
    }
}

