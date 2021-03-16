package com.zup.orangetalent.desafio.controlervacinas.controller;

import com.zup.orangetalent.desafio.controlervacinas.event.RecursoCriadoEvent;
import com.zup.orangetalent.desafio.controlervacinas.model.Usuario;
import com.zup.orangetalent.desafio.controlervacinas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ApplicationEventPublisher publisher;

    @PostMapping
    public ResponseEntity<Usuario> criar(@Valid @RequestBody  Usuario usuario ,
                                            HttpServletResponse httpServletResponse) {
        Usuario usuarioSalvo = usuarioService.salvar(usuario);

        publisher.publishEvent(new RecursoCriadoEvent(this , usuarioSalvo.getCodigo() , httpServletResponse));

        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSalvo);
    }

}
