package br.com.alura.loja.desconto;

import br.com.alura.loja.orcamento.Orcamento;

import java.math.BigDecimal;

public class DescontoOrcamentoMaisDeCincoItens extends DescontoOrcamento {

    public DescontoOrcamentoMaisDeCincoItens(DescontoOrcamento proximoDesconto) {
        super(proximoDesconto);
    }

    public BigDecimal calcular(Orcamento orcamento) {
        if (orcamento.getQuantidadeItens() > 5) {
            return orcamento.getValor().multiply(new BigDecimal("0.1"));
        }

        return proximoDesconto.calcular(orcamento);
    }
}
