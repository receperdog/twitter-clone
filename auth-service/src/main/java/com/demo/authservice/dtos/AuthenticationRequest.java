package com.demo.authservice.dtos;

public record AuthenticationRequest(
        String username,
        String password
) {}