package br.com.alura.rh.service.reajuste;

import br.com.alura.rh.ValidacaoException;
import br.com.alura.rh.model.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class ReajusteService_v01 {
    /**
     * Método de reajuste com 2 responsabilidades. Uma de validar se o funcionário está apto a receber o reajuste (2 regras a serem verificadas)
     * e outra seria reajustar o salário do funcionário.
     */
    public void reajustarSalario(Funcionario funcionario, BigDecimal aumento){
        BigDecimal salario = funcionario.getSalario();
        BigDecimal percentualReajuste = aumento.divide(salario, RoundingMode.HALF_UP);

        if (percentualReajuste.compareTo(new BigDecimal("0.4")) > 0) {
            throw new ValidacaoException("Reajuste nao pode ser superior a 40% do salario!");
        }
        LocalDate dataUltimoReajuste = funcionario.getDataUltimoReajuste();

        if (Objects.nonNull(dataUltimoReajuste)) {
            LocalDate dataAtual = LocalDate.now();
            long qtdeMesesDesdeUltimoReajuse = ChronoUnit.MONTHS.between(dataUltimoReajuste,dataAtual);

            if (qtdeMesesDesdeUltimoReajuse < 6) {
                throw new ValidacaoException("Intervalo entre reajustes deve ser de no mínimo 6 meses!");
            }
        }
        BigDecimal salarioReajustado = salario.add(aumento);
        funcionario.atualizarSalario(salarioReajustado);
    }
}
