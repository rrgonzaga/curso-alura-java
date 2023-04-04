package br.com.alura.loja.desconto;

import br.com.alura.loja.orcamento.Orcamento;

import java.math.BigDecimal;

public class DescontoOrcamentoValorMaiorQueQuinhentos extends DescontoOrcamento {

    public DescontoOrcamentoValorMaiorQueQuinhentos(DescontoOrcamento proximoDesconto) {
        super(proximoDesconto);
    }

    public BigDecimal calcular(Orcamento orcamento) {
        if (orcamento.getValor().compareTo(new BigDecimal("500")) > 0) {
            return orcamento.getValor().multiply(new BigDecimal("0.05"));
        }
        return proximoDesconto.calcular(orcamento);
    }
}
