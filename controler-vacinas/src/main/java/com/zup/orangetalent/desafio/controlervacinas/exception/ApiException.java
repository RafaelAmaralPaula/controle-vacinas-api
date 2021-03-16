package com.zup.orangetalent.desafio.controlervacinas.exception;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class ApiException {

    private String mensagemUsuario;
    private String mensagemDesenvolvedor;
    private HttpStatus httpStatus;
    private ZonedDateTime timesStamp;

    public ApiException(String messagemUsuario, String messageDesenvolvedor, HttpStatus httpStatus, ZonedDateTime timesStamp) {
        this.mensagemUsuario = messagemUsuario;
        this.mensagemDesenvolvedor = messageDesenvolvedor;
        this.httpStatus = httpStatus;
        this.timesStamp = timesStamp;
    }

    public String getMensagemUsuario() {
        return mensagemUsuario;
    }

    public void setMensagemUsuario(String mensagemUsuario) {
        this.mensagemUsuario = mensagemUsuario;
    }

    public String getMensagemDesenvolvedor() {
        return mensagemDesenvolvedor;
    }

    public void setmensagemDesenvolvedor(String mensagemDesenvolvedor) {
        this.mensagemDesenvolvedor = mensagemDesenvolvedor;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public ZonedDateTime getTimesStamp() {
        return timesStamp;
    }

    public void setTimesStamp(ZonedDateTime timesStamp) {
        this.timesStamp = timesStamp;
    }
}
