package br.com.alura.rh.service.reajuste.validacao;

import br.com.alura.rh.ValidacaoException;
import br.com.alura.rh.model.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ValidacaoPercentualReajuste implements ValidacaoReajuste {
    /**
     * Implementação do princípio de polimorfismo, ou seja, implementação do método
     * validar de forma diferente para cada implementação da interface ValidacaoReajuste
     */
    @Override
    public void validar(Funcionario funcionario, BigDecimal aumento) {
        BigDecimal salario = funcionario.getSalario();
        BigDecimal percentualReajuste = aumento.divide(salario, RoundingMode.HALF_UP);

        if (percentualReajuste.compareTo(new BigDecimal("0.4")) > 0) {
            throw new ValidacaoException("Reajuste não pode ser superior a 40% do salario!");
        }
    }
}
