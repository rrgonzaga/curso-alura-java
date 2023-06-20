package br.com.alura.loja.pedido;

import br.com.alura.loja.cliente.Cliente;
import br.com.alura.loja.orcamento.Orcamento;

import java.time.LocalDateTime;

public class Pedido {
    private Cliente cliente;
    private LocalDateTime data;
    private Orcamento orcamento;

    public Pedido(Cliente cliente, LocalDateTime data, Orcamento orcamento) {
        this.cliente = cliente;
        this.data = data;
        this.orcamento = orcamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public LocalDateTime getData() {
        return data;
    }

    public Orcamento getOrcamento() {
        return orcamento;
    }
}
