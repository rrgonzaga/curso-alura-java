package br.com.alura.tdd.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;

import br.com.alura.tdd.modelo.Funcionario;

public class BonusService {

	private final BigDecimal valorMaxDezPorcento = new BigDecimal("1000.00");

	/**
	 * Calcula bônus do funcionário
	 * @param funcionario Objeto funcionário
	 * @return valor do bônus ou lança exceção caso 10% do salário for maior que 1.000.
	 * @rule Se 10% do salário do funcionário for maior que 1.000,00, não recebe bonus. Caso contrário, o bônus será de 10% do salário.
	 */
	public BigDecimal calcularBonus(Funcionario funcionario) {
		BigDecimal valor = funcionario.getSalario().multiply(new BigDecimal("0.1"));
		if (valor.compareTo(valorMaxDezPorcento) > 0) {
			NumberFormat formatter = NumberFormat.getCurrencyInstance();
			String valorMaxFormatado = formatter.format(valorMaxDezPorcento);
			throw new IllegalArgumentException(String.format("10%s do salário do funcionário é maior que %s","%",valorMaxFormatado));
		}
		return valor.setScale(2, RoundingMode.HALF_UP);
	}

}
