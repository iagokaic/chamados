package com.sonda.apichamados.services;

import com.sonda.apichamados.exceptions.ObjetoNaoEncontradoException;
import com.sonda.apichamados.model.User;
import com.sonda.apichamados.repository.UserRepository;
import com.sonda.apichamados.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements BaseService<User> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User inserir(User obj) {
        return userRepository.save(obj);
    }

    @Override
    public User alterar(String id, User obj) {
        verificarExistencia(id);
        obj.setId(id);
        return userRepository.save(obj);
    }

    @Override
    public void excluir(String id) {
        verificarExistencia(id);
        userRepository.deleteById(id);
    }

    @Override
    public List<User> listar() {
        return userRepository.findAll();
    }

    @Override
    public User selecionar(String id) {
        verificarExistencia(id);
        User user = userRepository.findById(id).orElse(null);
        return user;
    }

    @Override
    public void verificarExistencia(User obj) {
        if(obj == null) {
            throw new ObjetoNaoEncontradoException("Usuario não encontrado no banco de dados");
        }
    }

    @Override
    public void verificarExistencia(String id) {
        User user = userRepository.findById(id).orElse(null);
        verificarExistencia(user);
    }
}
