package br.com.codenation.models;

import java.time.LocalDate;

public class Team {
    private Long id;
    private String nome;
    private LocalDate dataCriacao;
    private String corUniformePrincipal;
    private String corUnifirmeSecundario;

    public Team(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUnifirmeSecundario) {
        this.id = id;
        this.nome = nome;
        this.dataCriacao = dataCriacao;
        this.corUniformePrincipal = corUniformePrincipal;
        this.corUnifirmeSecundario = corUnifirmeSecundario;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public String getCorUniformePrincipal() {
        return corUniformePrincipal;
    }

    public String getCorUnifirmeSecundario() {
        return corUnifirmeSecundario;
    }
}
