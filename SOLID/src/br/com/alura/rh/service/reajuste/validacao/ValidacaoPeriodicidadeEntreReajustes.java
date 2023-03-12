package br.com.alura.rh.service.reajuste.validacao;

import br.com.alura.rh.ValidacaoException;
import br.com.alura.rh.model.Funcionario;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class ValidacaoPeriodicidadeEntreReajustes implements ValidacaoReajuste {

    /**
     * Implementação do princípio de polimorfismo, ou seja, implementação do método
     * validar de forma diferente para cada implementação da interface ValidacaoReajuste
     */
    public void validar(Funcionario funcionario, BigDecimal aumento) {
        LocalDate dataUltimoReajuste = funcionario.getDataUltimoReajuste();

        if (Objects.nonNull(dataUltimoReajuste)) {
            LocalDate dataAtual = LocalDate.now();
            long qtdeMesesDesdeUltimoReajuse = ChronoUnit.MONTHS.between(dataUltimoReajuste,dataAtual);

            if (qtdeMesesDesdeUltimoReajuse < 6) {
                throw new ValidacaoException("Intervalo entre reajustes deve ser de no mínimo 6 meses!");
            }
        }
    }
}
