package com.zup.orangetalent.desafio.controlervacinas.controller;

import com.zup.orangetalent.desafio.controlervacinas.model.Vacina;
import com.zup.orangetalent.desafio.controlervacinas.repository.VacinaRepository;
import com.zup.orangetalent.desafio.controlervacinas.service.VacinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/vacinacao")
public class VacinaController {

    @Autowired
    private VacinaRepository vacinaRepository;

    @Autowired
    private VacinaService vacinaService;

    @GetMapping
    public List<Vacina> listarTodasVacinas(){
        return  vacinaRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Vacina> criar(@Valid  @RequestBody  Vacina vacina){
        Vacina vacinaSalva = vacinaService.salvar(vacina);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                            .path("/{codigo}").buildAndExpand(vacinaSalva.getCodigo()).toUri();

        return ResponseEntity.created(uri).body(vacinaSalva);
    }

}
