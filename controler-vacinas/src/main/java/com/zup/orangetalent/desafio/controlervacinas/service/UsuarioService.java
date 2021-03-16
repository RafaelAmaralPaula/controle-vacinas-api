package com.zup.orangetalent.desafio.controlervacinas.service;

import com.zup.orangetalent.desafio.controlervacinas.model.Usuario;
import com.zup.orangetalent.desafio.controlervacinas.repository.UsuarioRepository;
import com.zup.orangetalent.desafio.controlervacinas.service.exception.UsuarioComEmailOuCpfJaExistenteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario salvar(Usuario usuario){

        verificarExistencia(usuario.getEmail() , usuario.getCpf());
        usuario.setDataNascimento(new Date());
        return usuarioRepository.save(usuario);
    }

    private void verificarExistencia(String email , String cpf){
        Usuario usuarioEncontradoPeloEmail = usuarioRepository.findByEmail(email);
        Usuario usuarioEncontradoPeloCpf = usuarioRepository.findByCpf(cpf);

        if(usuarioEncontradoPeloEmail != null || usuarioEncontradoPeloCpf !=null){
            throw new UsuarioComEmailOuCpfJaExistenteException("O e-mail ou cpf que foi informado já existe nossa base dados");
        }
    }

}
