package com.sonda.demo.handler;

import com.sonda.demo.exceptions.ObjetoNaoEncontradoException;
import com.sonda.demo.model.Erro;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ResourceExceptionHandler {
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Erro handlerErroValidacaoFormulariosException
            (MethodArgumentNotValidException e){
        Erro erro = new Erro();
        erro.setStatus(404);
        erro.setTitulo("Erro de validação dos dados de entrada!");
        erro.setTimestamp(System.currentTimeMillis());
        return erro;
    }

    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler(ObjetoNaoEncontradoException.class)
    public Erro handlerObjetoNaoEncontradoException
            (ObjetoNaoEncontradoException e, HttpServletRequest request){
        Erro erro = new Erro();
        erro.setStatus(404);
        erro.setTitulo(e.getMessage());
        erro.setTimestamp(System.currentTimeMillis());
        return erro;
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public Erro handlerDataIntegrityViolationException
            (DataIntegrityViolationException e, HttpServletRequest request){
        Erro erro = new Erro();
        erro.setStatus(400);
        erro.setTitulo("Violação de integridade dos dados!");
        erro.setTimestamp(System.currentTimeMillis());
        return erro;
    }
}
