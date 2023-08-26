package br.com.alura.loja.pedido.acao;

import br.com.alura.loja.pedido.Pedido;

import java.util.logging.Level;
import java.util.logging.Logger;

public class EnviarEmailPedido implements AcaoAposGeracaoPedido {
    private static final Logger LOGGER = Logger.getLogger(EnviarEmailPedido.class.getName());
    public void executarAcao(Pedido pedido) {
        LOGGER.log(Level.INFO, "Enviando e-mail com dados do pedido");
    }
}
