package io.github.mongo.login.controller.dto.request;

import java.util.List;

import io.github.mongo.login.entity.Roles;

public record LoginRequest(
        String username,
        String password,
        List<Roles> roles
) {
}
