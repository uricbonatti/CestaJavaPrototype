package io.uric.cesta.pessoas;

import java.time.LocalDate;
import java.time.Period;

public interface IPessoa {
    String getNome();
    void setNome(String nome);
    String getCpf();
    void setCpf(String cpf);
    LocalDate getDataNascimento();
    void setDataNascimento(LocalDate dataNascimento);
    int idade();
}
