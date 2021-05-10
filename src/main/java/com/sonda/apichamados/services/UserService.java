package com.sonda.apichamados.services;

import com.sonda.apichamados.model.User;
import com.sonda.apichamados.util.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements BaseService<User> {
    @Override
    public User inserir(User obj) {
        return null;
    }

    @Override
    public User alterar(Long id, User obj) {
        return null;
    }

    @Override
    public void excluir(Long id) {

    }

    @Override
    public List<User> listar() {
        return null;
    }

    @Override
    public User selecionar(Long id) {
        return null;
    }

    @Override
    public void verificarExistencia(User obj) {

    }

    @Override
    public void verificarExistencia(Long id) {

    }
}
