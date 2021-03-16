package com.zup.orangetalent.desafio.controlervacinas.service;

import com.zup.orangetalent.desafio.controlervacinas.model.Usuario;
import com.zup.orangetalent.desafio.controlervacinas.model.Vacina;
import com.zup.orangetalent.desafio.controlervacinas.repository.UsuarioRepository;
import com.zup.orangetalent.desafio.controlervacinas.repository.VacinaRepository;
import com.zup.orangetalent.desafio.controlervacinas.service.exception.UsuarioInexistenteExeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class VacinaService {

    @Autowired
    private VacinaRepository vacinaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Vacina salvar(Vacina vacina){
        Optional<Usuario> usuario = usuarioRepository.findById(vacina.getUsuario().getCodigo());

        if(!usuario.isPresent()){
            throw  new UsuarioInexistenteExeption("Não podemos vincular esse usuário a essa vacina pois o usuário não existe");
        }

        vacina.setUsuario(usuario.get());
        vacina.setDataAplicacao(new Date());
        return  vacinaRepository.save(vacina);
    }

}
