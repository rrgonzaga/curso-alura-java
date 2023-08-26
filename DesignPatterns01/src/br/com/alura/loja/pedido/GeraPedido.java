package br.com.alura.loja.pedido;

import br.com.alura.loja.cliente.Cliente;
import br.com.alura.loja.exceptions.DadosInsuficientesCriacaoPedidoException;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;


public class GeraPedido {
    private static final Logger LOGGER = Logger.getLogger(GeraPedido.class.getName());

    private final Cliente cliente;
    private final BigDecimal valorOrcamento;
    private final Integer quantidadeItens;

    public GeraPedido(Cliente cliente, BigDecimal valorOrcamento, Integer quantidadeItens) {
        this.cliente = cliente;
        this.valorOrcamento = valorOrcamento;
        this.quantidadeItens = quantidadeItens;

        if (Objects.isNull(cliente) || Objects.isNull(valorOrcamento) || Objects.isNull(quantidadeItens)) {
            throw new DadosInsuficientesCriacaoPedidoException("Erro ao criar o pedido");
        }
        LOGGER.log(Level.INFO,"Pedido criado com sucesso");
    }

    public Cliente getCliente() {
        return cliente;
    }

    public BigDecimal getValorOrcamento() {
        return valorOrcamento;
    }

    public Integer getQuantidadeItens() {
        return quantidadeItens;
    }
}
