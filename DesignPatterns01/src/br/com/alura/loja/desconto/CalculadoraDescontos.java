package br.com.alura.loja.desconto;

import br.com.alura.loja.orcamento.Orcamento;

import java.math.BigDecimal;

public class CalculadoraDescontos {

    public BigDecimal calcularDesconto(Orcamento orcamento) {
        DescontoOrcamento desconto = new DescontoOrcamentoMaisDeCincoItens(
                new DescontoOrcamentoValorMaiorQueQuinhentos(new SemDesconto()));

        return desconto.calcular(orcamento);
    }
}
