package br.com.alura.loja.orcamento.situacao;

import br.com.alura.loja.enumerations.Situacao;
import br.com.alura.loja.orcamento.Orcamento;

import java.math.BigDecimal;

public class Aprovado extends SituacaoOrcamento {
    @Override
    public String getDescricao() {
        return Situacao.APROVADO.getDescricao();
    }
    @Override
    public BigDecimal calcularValorDescontoExtra(Orcamento orcamento) {
        return orcamento.getValor().multiply(new BigDecimal("0.02"));
    }
}
