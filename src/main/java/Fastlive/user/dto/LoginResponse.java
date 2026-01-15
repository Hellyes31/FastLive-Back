package Fastlive.user.dto;

public record LoginResponse(
        Long id,
        String username,
        String email
) {}
