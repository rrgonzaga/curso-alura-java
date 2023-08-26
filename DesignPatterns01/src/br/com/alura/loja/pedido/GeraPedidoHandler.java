package br.com.alura.loja.pedido;

import br.com.alura.loja.orcamento.Orcamento;
import br.com.alura.loja.pedido.acao.AcaoAposGeracaoPedido;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Aqui podemos identificar o uso do design pattern Observer.
 * Esta classe (GeraPedidoHandler) no papel de publisher (editor)
 * notificando cada um de seus subscribes (assinantes (classes EnviarEmailPedido e SalvarPedido))
 * para que eles realizem alguma ação quando ocorrer o evento (geração de pedido) no editor.
 * Também foi realizado a implementação de inversão de controle. Em vez da classe editor implementar todas as ações
 * para a geração completa do pedido, cada ação ficou em uma classe separada, e a classe editor apenas notifica/invoca
 * cada classe de ação (subscribe) quando o evento de geração de pedido ocorrer.
 * A vantagem dessa inversão de controle é que o método execute não será alterado caso alguma nova ação
 * seja implementada como gerar nota fiscal, por exemplo. Basta criar uma nova classe para esta nova ação
 * e ela implementar a interface AcaoAposGeracaoPedido que esta nova classe também será notificada/invocada
 * quando ocorrer o evento de geração de pedido.
 * Também podemos identificar o uso do polimorfismo para o método executarAcao
 * das classes que implementam o tipo AcaoAposGeracaoPedido
 */
public class GeraPedidoHandler {
    private List<AcaoAposGeracaoPedido> acoes;

    public GeraPedidoHandler(List<AcaoAposGeracaoPedido> acoes) {
        this.acoes = acoes;
    }

    public void execute(GeraPedido dados) {
        Orcamento orcamento = new Orcamento(dados.getValorOrcamento(),dados.getQuantidadeItens());
        Pedido pedido = new Pedido(dados.getCliente(), LocalDateTime.now(), orcamento);

        acoes.forEach(acao -> acao.executarAcao(pedido));
    }
}
