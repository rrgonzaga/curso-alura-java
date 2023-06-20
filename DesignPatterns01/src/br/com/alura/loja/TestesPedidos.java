package br.com.alura.loja;

import br.com.alura.loja.cliente.Cliente;
import br.com.alura.loja.orcamento.Orcamento;
import br.com.alura.loja.pedido.Pedido;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TestesPedidos {

    public static void main(String[] args) {
        Cliente cliente = new Cliente("Rodrigo Gonzaga");
        Orcamento orcamento = new Orcamento(new BigDecimal("600"),4);
        LocalDateTime data = LocalDateTime.now();

        Pedido pedido = new Pedido(cliente,data,orcamento);

        System.out.println("Salvar pedido no banco de dados");
        System.out.println("Enviar email com os dados do novo pedido");
    }


}
