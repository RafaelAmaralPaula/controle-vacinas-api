package com.zup.orangetalent.desafio.controlervacinas.repository;

import com.zup.orangetalent.desafio.controlervacinas.model.Vacina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacinaRepository  extends JpaRepository<Vacina , Long> {
}
