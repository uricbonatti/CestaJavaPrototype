package io.uric.cesta.registroDoacoes;

import io.uric.cesta.pessoas.Pessoa;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Registro {
    private long idReg;
    private Pessoa pessoa;
    private LocalDate dataOperacao;
    private TipoRegistro operacao;
    private int qtd;



    public Registro(long idReg, Pessoa pessoa, TipoRegistro operacao, int qtd) {
        this.idReg = idReg;
        this.pessoa = pessoa;
        this.dataOperacao = LocalDate.now();
        this.operacao = operacao;
        this.qtd = qtd;
    }
    public int getQtd() {
        return qtd;
    }
    public long getIdReg() {
        return idReg;
    }

    public void setIdReg(long idReg) {
        this.idReg = idReg;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public LocalDate getDataOperacao() {
        return dataOperacao;
    }

    public void setDataOperacao(LocalDate dataOperacao) {
        this.dataOperacao = dataOperacao;
    }

    public TipoRegistro getOperacao() {
        return operacao;
    }

    public void setOperacao(TipoRegistro operacao) {
        this.operacao = operacao;
    }
    public void listarDoacao(){
        System.out.println("Operação: " + idReg);
        System.out.println("Tipo de Operacao: "+ operacao);
        if (operacao.equals(TipoRegistro.ENTRADA)){
            System.out.println("Doador: Sr(a). "+ pessoa.getNome());
            System.out.println("Entregou "+qtd+" Cestas Basicas para doação");
        } else {
            System.out.println("Beneficiario: Sr(a). "+ pessoa.getNome());
            System.out.println("Recebeu "+qtd+" Cestas Basicas.");
        }
        System.out.println("Realizada em " + dataOperacao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println("==============================================");
    }
}
