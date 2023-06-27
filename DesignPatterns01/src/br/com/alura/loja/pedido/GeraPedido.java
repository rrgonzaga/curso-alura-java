package br.com.alura.loja.pedido;

import br.com.alura.loja.cliente.Cliente;
import br.com.alura.loja.orcamento.Orcamento;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class GeraPedido {
    private final Cliente cliente;
    private final BigDecimal valorOrcamento;
    private final int quantidadeItens;

    public GeraPedido(Cliente cliente, BigDecimal valorOrcamento, int quantidadeItens) {
        this.cliente = cliente;
        this.valorOrcamento = valorOrcamento;
        this.quantidadeItens = quantidadeItens;
    }

    public void executa(){
        Orcamento orcamento = new Orcamento(this.valorOrcamento,this.quantidadeItens);
        Pedido pedido = new Pedido(this.cliente,LocalDateTime.now(),orcamento);

        System.out.println("Salvar pedido no banco de dados");
        System.out.println("Enviar email com os dados do novo pedido");
    }
}
