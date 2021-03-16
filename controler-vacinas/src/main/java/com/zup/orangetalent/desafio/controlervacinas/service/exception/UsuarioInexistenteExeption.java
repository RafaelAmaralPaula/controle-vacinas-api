package com.zup.orangetalent.desafio.controlervacinas.service.exception;

public class UsuarioInexistenteExeption extends  RuntimeException {

    public UsuarioInexistenteExeption(String mensagem){
        super(mensagem);
    }

    public UsuarioInexistenteExeption(String mensagem , Throwable cause){
        super(mensagem , cause);
    }

}
