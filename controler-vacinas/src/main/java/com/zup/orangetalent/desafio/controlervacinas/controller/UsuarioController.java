package com.zup.orangetalent.desafio.controlervacinas.controller;

import com.zup.orangetalent.desafio.controlervacinas.model.Usuario;
import com.zup.orangetalent.desafio.controlervacinas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> criar(@Valid @RequestBody  Usuario usuario){
        Usuario usuarioSalvo = usuarioService.salvar(usuario);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                            .path("/{codigo}").buildAndExpand(usuario.getCodigo()).toUri();

        return ResponseEntity.created(uri).body(usuarioSalvo);
    }

}
