package com.zup.orangetalent.desafio.controlervacinas.event.listener;

import com.zup.orangetalent.desafio.controlervacinas.event.RecursoCriadoEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;

@Component
public class RecursoCriadoListener implements ApplicationListener<RecursoCriadoEvent> {

    @Override
    public void onApplicationEvent(RecursoCriadoEvent recursoCriadoEvent) {
            Long codigo = recursoCriadoEvent.getCodigo();
            HttpServletResponse httpServletResponse = recursoCriadoEvent.getHttpServletResponse();

        adicionandoHeaderLocation(codigo, httpServletResponse);

    }

    private void adicionandoHeaderLocation(Long codigo, HttpServletResponse httpServletResponse) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                                        .path("/{codigo}").buildAndExpand(codigo).toUri();

        httpServletResponse.setHeader("Location" , uri.toASCIIString());
    }
}
