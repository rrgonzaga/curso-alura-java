package br.com.alura.loja.desconto;

import br.com.alura.loja.orcamento.Orcamento;

import java.math.BigDecimal;
public abstract class DescontoOrcamento {
    protected DescontoOrcamento proximoDesconto;

    protected DescontoOrcamento(DescontoOrcamento proximoDesconto) {
        this.proximoDesconto = proximoDesconto;
    }

    protected BigDecimal calcular(Orcamento orcamento) {
        if (deveAplicar(orcamento)) {
            return efetuarCalculo(orcamento);
        }

        return proximoDesconto.calcular(orcamento);
    }

    protected abstract BigDecimal efetuarCalculo(Orcamento orcamento);
    protected abstract boolean deveAplicar(Orcamento orcamento);
}
