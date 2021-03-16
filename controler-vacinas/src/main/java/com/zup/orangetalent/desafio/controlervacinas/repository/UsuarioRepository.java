package com.zup.orangetalent.desafio.controlervacinas.repository;

import com.zup.orangetalent.desafio.controlervacinas.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario , Long>{

    @Query("SELECT u FROM Usuario u WHERE u.email = ?1 ")
    public Usuario findByEmail(String email);

    @Query("SELECT u from Usuario u WHERE u.cpf = ?1")
    public Usuario findByCpf(String cpf);

}
