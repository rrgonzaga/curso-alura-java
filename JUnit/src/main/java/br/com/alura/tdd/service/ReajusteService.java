package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

import java.math.BigDecimal;

public class ReajusteService {

    public void concederReajuste(Funcionario funcionario, Desempenho desempenho) {

        BigDecimal valorReajuste;

        switch (desempenho) {
            case A_DESEJAR:
                valorReajuste = funcionario.getSalario().multiply(new BigDecimal(0.03));
                break;
            case BOM:
                valorReajuste = funcionario.getSalario().multiply(new BigDecimal(0.15));
                break;
            case OTIMO:
                valorReajuste = funcionario.getSalario().multiply(new BigDecimal(0.20));
                break;
            default:
                valorReajuste = BigDecimal.ZERO;
        }

        funcionario.reajustarSalario(valorReajuste);
    }
}
