package com.zup.orangetalent.desafio.controlervacinas.event;

import org.springframework.context.ApplicationEvent;

import javax.servlet.http.HttpServletResponse;

public class RecursoCriadoEvent extends ApplicationEvent {

    private Long codigo;

    private HttpServletResponse httpServletResponse;

    public RecursoCriadoEvent(Object source , Long codigo , HttpServletResponse response) {
        super(source);
        this.codigo = codigo;
        this.httpServletResponse = response;

    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public HttpServletResponse getHttpServletResponse() {
        return httpServletResponse;
    }

    public void setHttpServletResponse(HttpServletResponse httpServletResponse) {
        this.httpServletResponse = httpServletResponse;
    }
}
