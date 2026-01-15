package Fastlive.user;

import Fastlive.user.dto.*;
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

    @PutMapping("/update/{id}")
    public void updateUser(
            @PathVariable Long id,
            @RequestBody UpdateUserRequest request
            ) {
        userService.updateUser(id,request);
    }
}



