package io.github.mongo.login.repository;

import io.github.mongo.login.entity.Login;

public interface LoginRepository {
    Login salve(Login login);
    void delete(String id);
    Login update(Login login);
    Login findById(String id);
}