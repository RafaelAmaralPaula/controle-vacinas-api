package com.zup.orangetalent.desafio.controlervacinas.controller;

import com.zup.orangetalent.desafio.controlervacinas.event.RecursoCriadoEvent;
import com.zup.orangetalent.desafio.controlervacinas.model.Vacina;
import com.zup.orangetalent.desafio.controlervacinas.repository.VacinaRepository;
import com.zup.orangetalent.desafio.controlervacinas.service.VacinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
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

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping
    public List<Vacina> listarTodasVacinas(){
        return  vacinaRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Vacina> criar(@Valid  @RequestBody  Vacina vacina ,
                                        HttpServletResponse httpServletResponse){
        Vacina vacinaSalva = vacinaService.salvar(vacina);

        publisher.publishEvent(new RecursoCriadoEvent(this , vacinaSalva.getCodigo() , httpServletResponse));

        return ResponseEntity.status(HttpStatus.CREATED).body(vacinaSalva);
    }

}
