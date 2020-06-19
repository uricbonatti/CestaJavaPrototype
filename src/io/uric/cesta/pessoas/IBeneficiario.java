package io.uric.cesta.pessoas;

import java.time.LocalDate;

public interface IBeneficiario extends IPessoa {

    long getIdBeneficiario();
    void setIdBeneficiario(long idBeneficiario);
    LocalDate getProximaCesta();
    LocalDate getUltimaCestaRecebida();
    void setUltimaCestaRecebida(LocalDate ultimaCesta);
    void atualizarDoacoes( int qtdCestas);
    void atualizarDoacoes(int qtdCestas, LocalDate ultimaCesta);
    int getNumPessoasNaFamilia();
    void setNumPessoasNaFamilia(int numPessoasNaFamilia);

}
