package io.uric.cesta.pessoas;

public interface IDoador extends IPessoa {
    long getIdDoador();
    void setIdDoador(long idDoador);
    String getTelefone();
    void setTelefone(String telefone);
    long getNumDoacoes();
    void setNumDoacoes(long numDoacoes);
    void novaDoacao();
    void exibirDoador();

}
