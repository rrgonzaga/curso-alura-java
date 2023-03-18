package br.com.alura.loja;

import br.com.alura.loja.imposto.CalculadoraImpostos;
import br.com.alura.loja.imposto.ICMS;
import br.com.alura.loja.orcamento.Orcamento;

import java.math.BigDecimal;

public class TestesImpostos {
    public static void main(String[] args) {
        Orcamento orcamento = new Orcamento(new BigDecimal("100"));
        CalculadoraImpostos calculadoraImpostos = new CalculadoraImpostos();

        System.out.println(calculadoraImpostos.calcularImposto(orcamento, new ICMS()));
    }
}
