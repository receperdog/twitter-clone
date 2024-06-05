package com.demo.authservice.dtos;

import com.demo.authservice.model.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

public record UserRegisterRequest(
        String name,
        String username,
        @NotNull
        String password,
        @Email
        String email,
        @NotNull
        Set<Role> authorities
) {
}
