package io.uric.cesta.pessoas;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Beneficiario  extends Pessoa implements IBeneficiario{

    private long idBeneficiario;
    private int numPessoasNaFamilia;
    private String endereco;
    private LocalDate ultimaCestaRecebida;
    private LocalDate proximaCesta;

    public Beneficiario(
            String nome,
            String cpf,
            LocalDate dataNascimento,
            String endereco,
            long idBeneficiario,
            int numPessoasNaFamilia,
            LocalDate ultimaCestaRecebida,
            int qtdCestas
    ) {
        super(nome, cpf, dataNascimento);
        this.idBeneficiario = idBeneficiario;
        this.numPessoasNaFamilia = numPessoasNaFamilia;
        this.ultimaCestaRecebida = ultimaCestaRecebida;
        this.proximaCesta = this.ultimaCestaRecebida.plusDays(
                (20*qtdCestas)/this.numPessoasNaFamilia
        );
        this.endereco = endereco;
    }
    public long getIdBeneficiario() {
        return idBeneficiario;
    }
    public void setIdBeneficiario(long idBeneficiario) {
        this.idBeneficiario = idBeneficiario;
    }
    public LocalDate getProximaCesta() {
        return proximaCesta;
    }
    public LocalDate getUltimaCestaRecebida() {
        return ultimaCestaRecebida;
    }
    public void setUltimaCestaRecebida(LocalDate ultimaCesta){
        this.ultimaCestaRecebida = ultimaCesta;
    }
    public void atualizarDoacoes( int qtdCestas){
        this.ultimaCestaRecebida = LocalDate.now();
        this.proximaCesta = this.ultimaCestaRecebida.plusDays(
                (20*qtdCestas)/this.numPessoasNaFamilia
        );
    }
    public void atualizarDoacoes(int qtdCestas, LocalDate ultimaCesta){
        this.ultimaCestaRecebida = ultimaCesta;
        this.proximaCesta = ultimaCesta.plusDays(
                (20*qtdCestas)/this.numPessoasNaFamilia
        );
    }
    public int getNumPessoasNaFamilia() {
        return numPessoasNaFamilia;
    }
    public void setNumPessoasNaFamilia(int numPessoasNaFamilia) {
        this.numPessoasNaFamilia = numPessoasNaFamilia;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public void exibirBeneficiario(){
        System.out.println("Sr(a). "+ this.getNome());
        System.out.println("Idade: "+ this.idade());
        System.out.println("Cadastrado no Sistema em: "+
                this.getDataCadastro().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println("Pessoas na Familia: " + this.numPessoasNaFamilia);
        System.out.println("Data da Ultima Cesta Basica Recebida: "+
                this.ultimaCestaRecebida.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println("Data prevista para receber a proxima Cesta Basica: "+
                this.proximaCesta.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println("Endereço: " + this.endereco);
    }
}
