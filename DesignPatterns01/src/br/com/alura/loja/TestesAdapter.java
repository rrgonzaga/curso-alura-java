package br.com.alura.loja;

import br.com.alura.loja.http.JavaHttpClient;
import br.com.alura.loja.orcamento.Orcamento;
import br.com.alura.loja.orcamento.RegistroDeOrcamento;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestesAdapter {
    private static final Logger LOGGER = Logger.getLogger(TestesAdapter.class.getName());
    public static void main(String[] args){

        Orcamento primeiroOrcamento = new Orcamento(new BigDecimal("200"), 6);

        LOGGER.log(Level.INFO,String.format("Situação inicial do primeiro orçamento: %s",primeiroOrcamento.getSituacao().getDescricao()));
        primeiroOrcamento.getSituacao().atualizarValorOrcamento(primeiroOrcamento);
        LOGGER.log(Level.INFO,String.format("Valor do primeiro orçamento: %s",primeiroOrcamento.getValor()));
        primeiroOrcamento.getSituacao().finalizar(primeiroOrcamento);
        LOGGER.log(Level.INFO,String.format("Situação do primeiro orçamento: %s",primeiroOrcamento.getSituacao().getDescricao()));
        primeiroOrcamento.getSituacao().atualizarValorOrcamento(primeiroOrcamento);
        LOGGER.log(Level.INFO,String.format("Valor do primeiro orçamento: %s", primeiroOrcamento.getValor()));
        primeiroOrcamento.getSituacao().analisar(primeiroOrcamento);
        LOGGER.log(Level.INFO,String.format("Situação do primeiro orçamento: %s", primeiroOrcamento.getSituacao().getDescricao()));
        primeiroOrcamento.getSituacao().atualizarValorOrcamento(primeiroOrcamento);
        LOGGER.log(Level.INFO,String.format("Valor do primeiro orçamento: %s",primeiroOrcamento.getValor()));
        primeiroOrcamento.getSituacao().aprovar(primeiroOrcamento);
        LOGGER.log(Level.INFO,String.format("Situação final do primeiro orçamento: %s",primeiroOrcamento.getSituacao().getDescricao()));
        primeiroOrcamento.getSituacao().atualizarValorOrcamento(primeiroOrcamento);
        LOGGER.log(Level.INFO,String.format("Valor final do primeiro orçamento: %s", primeiroOrcamento.getValor()));
        LOGGER.log(Level.INFO,"-------------------------------------------------------------------------------------------");

        RegistroDeOrcamento registroDeOrcamento = new RegistroDeOrcamento(new JavaHttpClient());
        registroDeOrcamento.registrar(primeiroOrcamento);



    }
}
