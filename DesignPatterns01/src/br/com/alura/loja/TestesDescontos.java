package br.com.alura.loja;

import br.com.alura.loja.desconto.CalculadoraDescontos;
import br.com.alura.loja.orcamento.Orcamento;

import java.math.BigDecimal;

public class TestesDescontos {
    public static void main(String[] args) {
        Orcamento primeiroOrcamento = new Orcamento(new BigDecimal("200"), 6);
        Orcamento segundoOrcamento = new Orcamento(new BigDecimal("1000"), 1);
        Orcamento terceiroOrcamento = new Orcamento(new BigDecimal("150"),1);

        CalculadoraDescontos calculadoraDescontos = new CalculadoraDescontos();

        System.out.println("Desconto do primeiro orçamento: " + calculadoraDescontos.calcularDesconto(primeiroOrcamento));
        System.out.println("Desconto do segundo orçamento: " + calculadoraDescontos.calcularDesconto(segundoOrcamento));
        System.out.println("Desconto do terceiro orçamento: " + calculadoraDescontos.calcularDesconto(terceiroOrcamento));
    }
}
