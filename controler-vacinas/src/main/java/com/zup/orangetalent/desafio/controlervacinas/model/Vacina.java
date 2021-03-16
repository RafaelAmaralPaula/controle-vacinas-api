package com.zup.orangetalent.desafio.controlervacinas.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "tb_vacina")
public class Vacina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @NotBlank
    private String nome;

    @Column(name = "data_aplicacao")
    private Date dataAplicacao;

    @ManyToOne
    private Usuario usuario;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataAplicacao() {
        return dataAplicacao;
    }

    public void setDataAplicacao(Date dataAplicacao) {
        this.dataAplicacao = dataAplicacao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vacina vacina = (Vacina) o;
        return codigo.equals(vacina.codigo) &&
                Objects.equals(nome, vacina.nome) &&
                Objects.equals(dataAplicacao, vacina.dataAplicacao) &&
                Objects.equals(usuario, vacina.usuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, nome, dataAplicacao, usuario);
    }
}
