package io.uric.cesta.pessoas;

import java.time.LocalDate;
import java.time.Period;

public abstract class Pessoa implements IPessoa {

    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private LocalDate dataCadastro;


    public Pessoa(String nome, String cpf, LocalDate dataNascimento){
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.dataCadastro = LocalDate.now();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public int idade(){
        final Period periodo = Period.between(this.dataNascimento, LocalDate.now());
        return periodo.getYears();
    }
}
