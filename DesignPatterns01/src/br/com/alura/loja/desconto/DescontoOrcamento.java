package br.com.alura.loja.desconto;

import br.com.alura.loja.orcamento.Orcamento;

import java.math.BigDecimal;

public abstract class DescontoOrcamento {
    protected DescontoOrcamento proximoDesconto;

    protected DescontoOrcamento(DescontoOrcamento proximoDesconto) {
        this.proximoDesconto = proximoDesconto;
    }

    public abstract BigDecimal calcular(Orcamento orcamento);
}
