package br.com.alura.loja;

import br.com.alura.loja.orcamento.Orcamento;

import java.math.BigDecimal;

public class TestesSituacaoOrcamento {

    public static void main(String[] args) {
        Orcamento primeiroOrcamento = new Orcamento(new BigDecimal("200"), 6);

        System.out.println("Situação inicial do primeiro orçamento: " + primeiroOrcamento.getSituacao().getDescricao());
        primeiroOrcamento.getSituacao().atualizarValorOrcamento(primeiroOrcamento);
        System.out.println("Valor do primeiro orçamento: " + primeiroOrcamento.getValor());
        primeiroOrcamento.getSituacao().finalizar(primeiroOrcamento);
        System.out.println("Situação do primeiro orçamento: " + primeiroOrcamento.getSituacao().getDescricao());
        primeiroOrcamento.getSituacao().atualizarValorOrcamento(primeiroOrcamento);
        System.out.println("Valor do primeiro orçamento: " + primeiroOrcamento.getValor());
        primeiroOrcamento.getSituacao().analisar(primeiroOrcamento);
        System.out.println("Situação do primeiro orçamento: " + primeiroOrcamento.getSituacao().getDescricao());
        primeiroOrcamento.getSituacao().atualizarValorOrcamento(primeiroOrcamento);
        System.out.println("Valor do primeiro orçamento: " + primeiroOrcamento.getValor());
        primeiroOrcamento.getSituacao().aprovar(primeiroOrcamento);
        System.out.println("Situação final do primeiro orçamento: " + primeiroOrcamento.getSituacao().getDescricao());
        primeiroOrcamento.getSituacao().atualizarValorOrcamento(primeiroOrcamento);
        System.out.println("Valor final do primeiro orçamento: " + primeiroOrcamento.getValor());
        System.out.println("-------------------------------------------------------------------------------------------");

        Orcamento segundoOrcamento = new Orcamento(new BigDecimal("1000"), 1);
        segundoOrcamento.getSituacao().finalizar(segundoOrcamento);
        segundoOrcamento.getSituacao().analisar(segundoOrcamento);
        segundoOrcamento.getSituacao().reprovar(segundoOrcamento);
        System.out.println("Situação final do segundo orçamento: " + segundoOrcamento.getSituacao().getDescricao());
        System.out.println("-------------------------------------------------------------------------------------------");

        Orcamento terceiroOrcamento = new Orcamento(new BigDecimal("150"),1);
        terceiroOrcamento.getSituacao().finalizar(terceiroOrcamento);
        terceiroOrcamento.getSituacao().encerrar(terceiroOrcamento);
        terceiroOrcamento.getSituacao().analisar(terceiroOrcamento);
        System.out.println("Situação final do terceiro orçamento: " + terceiroOrcamento.getSituacao().getDescricao());
        System.out.println("-------------------------------------------------------------------------------------------");
    }
}
