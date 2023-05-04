package br.com.alura.loja;

import br.com.alura.loja.orcamento.Orcamento;

import java.math.BigDecimal;

public class TestesSituacaoOrcamento {

    public static void main(String[] args) {
        Orcamento primeiroOrcamento = new Orcamento(new BigDecimal("200"), 6);
        Orcamento segundoOrcamento = new Orcamento(new BigDecimal("1000"), 1);
        Orcamento terceiroOrcamento = new Orcamento(new BigDecimal("150"),1);

        primeiroOrcamento.finalizar();
        primeiroOrcamento.analisar();
        primeiroOrcamento.aprovar();
        System.out.println("Situação do primeiro orçamento: " + primeiroOrcamento.getSituacao().getDescricao());

        segundoOrcamento.finalizar();
        segundoOrcamento.analisar();
        segundoOrcamento.reprovar();
        System.out.println("Situação do segundo orçamento: " + segundoOrcamento.getSituacao().getDescricao());

        terceiroOrcamento.finalizar();
        terceiroOrcamento.encerrar();
        System.out.println("Situação do terceiro orçamento: " + terceiroOrcamento.getSituacao().getDescricao());
    }
}
