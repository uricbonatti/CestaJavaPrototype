package io.uric.cesta.pessoas;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Doador extends Pessoa implements IDoador{

    private long idDoador;
    private String telefone;
    private long numDoacoes;

    public Doador(long idDoador, String nome, String cpf, LocalDate dataNascimento,String telefone, long numDoacoes) {
        super(nome, cpf, dataNascimento);
        this.idDoador = idDoador;
        this.numDoacoes = numDoacoes;
        this.telefone = telefone;
    }

    public long getIdDoador() {
        return idDoador;
    }

    public void setIdDoador(long idDoador) {
        this.idDoador = idDoador;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public long getNumDoacoes() {
        return numDoacoes;
    }

    public void setNumDoacoes(long numDoacoes) {
        this.numDoacoes = numDoacoes;
    }
    public void novaDoacao(){
        this.numDoacoes++;
    }
    public void exibirDoador(){

        System.out.println("Sr(a). "+ this.getNome());
        System.out.println("Idade: "+ this.idade());
        System.out.println("Cadastrado no Sistema em: "+
            this.getDataCadastro().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println("Telefone" + this.telefone);
        System.out.println("============================");
    }


}
