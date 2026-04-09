package io.github.mongo.login.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.github.mongo.login.controller.adapter.LoginControllerAdapter;
import io.github.mongo.login.controller.dto.request.LoginRequest;
import io.github.mongo.login.controller.dto.response.LoginResponse;
import io.github.mongo.login.entity.Login;
import io.github.mongo.login.repository.LoginRepository;

@RestController
public class LoginController {

    public final LoginRepository loginRepository;

    public LoginController(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @PostMapping("/login/cadastrar")
    public LoginResponse salvar(@RequestBody LoginRequest request) {
        Login login = LoginControllerAdapter.castRequest(request);
        Login loginSalvo = loginRepository.salve(login);
        return LoginControllerAdapter.castResponse(loginSalvo);
    }

    @PutMapping("/login/atualizar")
    public LoginResponse atualizar(@RequestBody LoginRequest request) {
        Login login = LoginControllerAdapter.castRequest(request);
        Login loginAtualizado = loginRepository.update(login);
        return LoginControllerAdapter.castResponse(loginAtualizado);
    }

    @DeleteMapping("/login/deletar")
    public void deletar(@RequestBody LoginRequest request) {
        Login login = LoginControllerAdapter.castRequest(request);
        loginRepository.delete(login.id());
        return;
    }

    @GetMapping("/login/buscar")
    public LoginResponse buscar(@RequestBody LoginRequest request) {
        Login login = LoginControllerAdapter.castRequest(request);
        Login loginBuscado = loginRepository.findById(login.id());
        return LoginControllerAdapter.castResponse(loginBuscado);
    }

    @GetMapping("/login")
    public String login() {
        return "Realizar Login!";
    }

}
