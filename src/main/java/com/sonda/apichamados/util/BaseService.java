package com.sonda.apichamados.util;

import java.util.List;

public interface BaseService<T> {
    public T inserir(T obj);
    public T alterar(Long id, T obj);
    public void excluir(Long id);
    public List<T> listar();
    public T selecionar(Long id);
    public void verificarExistencia(T obj);
    public void verificarExistencia(Long id);
}
