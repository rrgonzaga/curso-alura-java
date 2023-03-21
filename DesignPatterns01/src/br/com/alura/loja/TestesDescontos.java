package br.com.alura.loja;

import br.com.alura.loja.desconto.CalculadoraDescontos;
import br.com.alura.loja.orcamento.Orcamento;

import java.math.BigDecimal;

public class TestesDescontos {
    public static void main(String[] args) {
        Orcamento primeiroOrcamento = new Orcamento(new BigDecimal("200"), 4);
        Orcamento segundoOrcamento = new Orcamento(new BigDecimal("1000"), 1);

        CalculadoraDescontos calculadoraDescontos = new CalculadoraDescontos();

        System.out.println("Desconto do primeiro orçamento: " + calculadoraDescontos.calcular(primeiroOrcamento));
        System.out.println("Desconto do segundo orçamento: " + calculadoraDescontos.calcular(segundoOrcamento));
    }
}
