package br.com.alura.rh.service.reajuste;

import br.com.alura.rh.model.Funcionario;
import br.com.alura.rh.service.reajuste.validacao.ValidacaoReajuste;

import java.math.BigDecimal;
import java.util.List;

public class ReajusteService {

    List<ValidacaoReajuste> validacoes;

    public ReajusteService(List<ValidacaoReajuste> validacoes) {
        this.validacoes = validacoes;
    }

    /**
     * Método de reajuste com responsabilidade única, a de conceder o reajuste do salário.
     * A responsabilidade de validação para verificar se o reajuste pode ser concedido
     * foi delegada para outras classes de validação.
     * OBS.1: Note que existe um acoplamento desta classe com a interface ValidacaoReajuste.
     * Boa prática: Dê preferência por fazer acoplamento com interfaces
     * e evite fazer acoplamento com classes concretas.
     */
    public void reajustarSalario(Funcionario funcionario, BigDecimal aumento){
        this.validacoes.forEach(validacao -> validacao.validar(funcionario,aumento));

        BigDecimal salarioReajustado = funcionario.getSalario().add(aumento);
        funcionario.atualizarSalario(salarioReajustado);
    }
}
