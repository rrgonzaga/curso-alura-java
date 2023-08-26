package br.com.alura.loja.pedido.acao;

import br.com.alura.loja.pedido.Pedido;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SalvarPedido implements AcaoAposGeracaoPedido{
    private static final Logger LOGGER = Logger.getLogger(SalvarPedido.class.getName());
    public void executarAcao(Pedido pedido) {
        LOGGER.log(Level.INFO, "Salvando pedido com dados no banco de dados");
    }
}
