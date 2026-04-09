package io.github.mongo.login.entity;

import java.util.List;

public record Login(
        String id,
        String userName,
        String password,
        List<Roles> roles
) {
}