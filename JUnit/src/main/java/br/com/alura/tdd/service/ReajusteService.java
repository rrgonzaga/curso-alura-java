package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;

public class ReajusteService {

    public void concederReajuste(@NotNull Funcionario funcionario, @NotNull Desempenho desempenho) {
        BigDecimal valorReajuste = funcionario.getSalario().multiply(desempenho.getPercentualReajuste());
        funcionario.reajustarSalario(valorReajuste);
    }
}
