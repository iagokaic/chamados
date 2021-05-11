package com.sonda.apichamados.services;

import com.sonda.apichamados.exceptions.ObjetoNaoEncontradoException;
import com.sonda.apichamados.model.Chamado;
import com.sonda.apichamados.repository.ChamadoRepository;
import com.sonda.apichamados.util.BaseService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChamadoService implements BaseService<Chamado> {

    @Autowired
    private ChamadoRepository chamadoRepository;

    @Override
    public Chamado inserir(Chamado obj) {
        return chamadoRepository.save(obj);
    }

    @Override
    public Chamado alterar(String id, Chamado obj) {
        verificarExistencia(id);
        obj.setId(id);
        return chamadoRepository.save(obj);
    }

    @Override
    public void excluir(String id) {
        verificarExistencia(id);
        chamadoRepository.deleteById(new ObjectId(id));
    }

    @Override
    public List<Chamado> listar() {
        return chamadoRepository.findAll();
    }

    @Override
    public Chamado selecionar(String id) {
        verificarExistencia(id);
        Chamado chamado = chamadoRepository.findById(new ObjectId(id)).orElse(null);
        return chamado;
    }

    @Override
    public void verificarExistencia(Chamado obj) {
        if(obj == null) {
            throw new ObjetoNaoEncontradoException("Chamado não encontrado no banco de dados");
        }
    }

    @Override
    public void verificarExistencia(String id) {
        Chamado chamado = chamadoRepository.findById(new ObjectId(id)).orElse(null);
        verificarExistencia(chamado);
    }
}
