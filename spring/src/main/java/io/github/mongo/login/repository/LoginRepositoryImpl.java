package io.github.mongo.login.repository;


import org.springframework.stereotype.Repository;

import io.github.mongo.login.entity.Login;
import io.github.mongo.login.repository.adapter.LoginRepositoryAdapter;
import io.github.mongo.login.repository.mongo.LoginRepositoryWithMongoDB;
import io.github.mongo.login.repository.orm.LoginOrmMongo;

@Repository
public class LoginRepositoryImpl implements LoginRepository {

    private final LoginRepositoryWithMongoDB repository;

    public LoginRepositoryImpl(LoginRepositoryWithMongoDB repository) {
        this.repository = repository;
    }

    @Override
    public Login salve(Login login) {
        LoginOrmMongo orm = LoginRepositoryAdapter.castEntity(login);
        LoginOrmMongo ormSave = repository.save(orm);
        return LoginRepositoryAdapter.castOrm(ormSave);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public Login update(Login login) {
        LoginOrmMongo orm = LoginRepositoryAdapter.castEntity(login);
        LoginOrmMongo ormSave = repository.save(orm);
        return LoginRepositoryAdapter.castOrm(ormSave);
    }

    @Override
    public Login findById(String id) {
        LoginOrmMongo orm = repository.findById(id).orElse(null);
        return orm != null ? LoginRepositoryAdapter.castOrm(orm) : null;
    }
}
