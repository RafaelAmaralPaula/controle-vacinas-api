package com.zup.orangetalent.desafio.controlervacinas.service.exception;

public class UsuarioComEmailOuCpfJaExistenteException extends RuntimeException {

    public UsuarioComEmailOuCpfJaExistenteException(String mensagem){
        super(mensagem);
    }

    public UsuarioComEmailOuCpfJaExistenteException(String mensagem , Throwable cause){
        super(mensagem , cause);
    }

}
