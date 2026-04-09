package io.github.mongo.login.controller.adapter;


import java.util.UUID;

import io.github.mongo.login.controller.dto.request.LoginRequest;
import io.github.mongo.login.controller.dto.response.LoginResponse;
import io.github.mongo.login.entity.Login;

public class LoginControllerAdapter {
    private LoginControllerAdapter() {
    }

    public static Login castRequest(LoginRequest request) {
        return new Login(
                UUID.randomUUID().toString(),
                request.username(),
                request.password(),
                request.roles());
    }

    public static LoginResponse castResponse(Login login) {
        return new LoginResponse("Login cadastrado com sucesso: " + login.id());
    }
}
