package br.com.alura.loja;

import br.com.alura.loja.cliente.Cliente;
import br.com.alura.loja.pedido.GeraPedido;
import br.com.alura.loja.pedido.GeraPedidoHandler;

import java.math.BigDecimal;

public class TestesPedidos {

    /**
     * Método main representando uma interface de entrada de dados com o usuário para a geração de um pedido.
     * @param args
     * Obs: O padrão Command sugere que os objetos GUI (Graphical User Interface) não devem enviar
     * solicitações diretamente para a camanda de negócios e que a implementação de um caso de uso
     * deve ser extraído para uma classe específica ao invés de estar implementado na
     * CLI (Common Language Interface)
     */
    public static void main(String[] args) {

            args = new String[3];
            args[0] = "Rodrigo";
            args[1] = "1500";
            args[2] = "8";

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
