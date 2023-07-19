package br.com.alura.loja.pedido;

import br.com.alura.loja.cliente.Cliente;

import java.math.BigDecimal;

public class GeraPedido {
    private final Cliente cliente;
    private final BigDecimal valorOrcamento;
    private final int quantidadeItens;

    public GeraPedido(Cliente cliente, BigDecimal valorOrcamento, int quantidadeItens) {
        this.cliente = cliente;
        this.valorOrcamento = valorOrcamento;
        this.quantidadeItens = quantidadeItens;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public BigDecimal getValorOrcamento() {
        return valorOrcamento;
    }

    public int getQuantidadeItens() {
        return quantidadeItens;
    }
}
