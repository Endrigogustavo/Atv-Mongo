package io.github.mongo.login.repository.orm;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "login")
public record LoginOrmMongo(
        @Id
        String id,
        String username,
        String password,
        List<Object> roles
) {
}