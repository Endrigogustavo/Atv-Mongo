package io.github.mongo.login.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.mongo.login.repository.LoginRepository;
import io.github.mongo.login.repository.LoginRepositoryImpl;
import io.github.mongo.login.repository.mongo.LoginRepositoryWithMongoDB;

@Configuration
public class RepositoryConfig {

    @Bean
    @ConditionalOnMissingBean(LoginRepository.class)
    public LoginRepository loginRepository(LoginRepositoryWithMongoDB repository) {
        return new LoginRepositoryImpl(repository);
    }
}
