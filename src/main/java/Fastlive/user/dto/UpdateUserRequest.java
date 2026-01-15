package Fastlive.user.dto;

public record UpdateUserRequest(
   String username,
   String email,
   String password
) {}
