package br.com.alura.loja;

import br.com.alura.loja.cliente.Cliente;
import br.com.alura.loja.pedido.GeraPedido;
import br.com.alura.loja.pedido.GeraPedidoHandler;

import java.math.BigDecimal;

public class TestesPedidos {

    /**
     * Método main representando uma interface de entrada de dados com o usuário para a geração de um pedido.
     * @param args
     */
    public static void main(String[] args) {
        String nomeCliente = args[0];
        Cliente cliente = new Cliente(nomeCliente);

        BigDecimal valorOrcamento = new BigDecimal(args[1]);
        int qtdeItens = Integer.parseInt(args[2]);

        gerarPedido(cliente, valorOrcamento,qtdeItens);

    }

    private static void gerarPedido(Cliente cliente, BigDecimal valorOrcamento, int qtdeItens) {
        GeraPedido geraPedido = new GeraPedido(cliente,valorOrcamento,qtdeItens);
        GeraPedidoHandler geraPedidoHandler = new GeraPedidoHandler(/*dependencias*/);
        geraPedidoHandler.execute(geraPedido);
    }


}
