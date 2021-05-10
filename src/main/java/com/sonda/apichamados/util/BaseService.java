package com.sonda.apichamados.util;

import java.util.List;

public interface BaseService<T> {
    public T inserir(T obj);
    public T alterar(String id, T obj);
    public void excluir(String id);
    public List<T> listar();
    public T selecionar(String id);
    public void verificarExistencia(T obj);
    public void verificarExistencia(String id);
}
