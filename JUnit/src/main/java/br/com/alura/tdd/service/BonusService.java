package br.com.alura.tdd.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.alura.tdd.modelo.Funcionario;

public class BonusService {

	/**
	 * Calcula bônus do funcionário
	 * @param funcionario Objeto funcionário
	 * @return valor do bônus
	 * @rule Se 10% do salário do funcionário for maior que 1.000,00, não recebe bonus.
	 */
	public BigDecimal calcularBonus(Funcionario funcionario) {
		if (funcionario.getSalario().compareTo(new BigDecimal(10500.00)) > 0) {
			throw new IllegalArgumentException("Funcionario com salário maior que 10.500,00 reais");
		}
		BigDecimal valor = funcionario.getSalario().multiply(new BigDecimal("0.1"));
		if (valor.compareTo(new BigDecimal("1000")) > 0) {
			valor = BigDecimal.ZERO;
		}
		return valor.setScale(2, RoundingMode.HALF_UP);
	}

}
