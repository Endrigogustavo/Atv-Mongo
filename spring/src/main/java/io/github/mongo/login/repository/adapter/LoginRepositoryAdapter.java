package io.github.mongo.login.repository.adapter;

import java.util.List;

import io.github.mongo.login.entity.Login;
import io.github.mongo.login.entity.Roles;
import io.github.mongo.login.repository.orm.LoginOrmMongo;

public class LoginRepositoryAdapter {
    private LoginRepositoryAdapter() {
    }

    public static Login castOrm(LoginOrmMongo orm) {
        List<Roles> roles = orm.roles() != null
                ? orm.roles().stream().map(r -> Roles.valueOf(r.toString())).toList()
                : List.of();
        return new Login(
                orm.id(),
                orm.username(),
                orm.password(),
                roles);
    }

    public static LoginOrmMongo castEntity(Login entity) {
        List<Object> roles = entity.roles() != null
                ? entity.roles().stream().map(r -> (Object) r.name()).toList()
                : List.of();
        return new LoginOrmMongo(
                entity.id(),
                entity.userName(),
                entity.password(),
                roles);
    }
}
