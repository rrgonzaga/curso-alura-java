package br.com.alura.loja.orcamento;

import br.com.alura.loja.exceptions.OrcamentoNaoAprovadoException;
import br.com.alura.loja.http.HttpAdapter;

import java.util.Map;

/**
 * Vantagem do padrão Adapter: princípio de responsabilidade única.
 * - Delegamos o envio do orçamento (a lógica de envio) para uma classe cliente Http que implementa a interface HttpAdapter
 * Outra vantagem do padrão Adapter: princípio aberto/fechado.
 * - Podemos passar qualquer adaptador cliente http que implemente a interface HttpAdapter sem quebrar o código dessa classe.
 * - A classe está aberta para receber qualquer classe que implemente a interface http mas fechada para alterações
 *   internas do seu próprio código.
 *
 * OBS.: Detalhes de infraestrutura devem ser abstraídos através de interfaces e o padrão Adapter nos ajuda a trocar detalhes
 * de infraestrutura sem muitas dores de cabeça. Nesta classe podemos trocar o cliente http sem problemas para enviar um
 * post
 *
 */
public class RegistroDeOrcamento {
    private HttpAdapter http;

    public RegistroDeOrcamento(HttpAdapter http) {
        this.http = http;
    }

    public void registrar (Orcamento orcamento){

        if(!orcamento.isAprovado()){
            throw new OrcamentoNaoAprovadoException("Orcamento não está aprovado. Não é possível registrá-lo");
        }

        String url = "http://api.externa/orcamento";
        Map<String, Object> dados = Map.of(
                "valor",orcamento.getValor(),
                "quantidadeItens",orcamento.getQuantidadeItens());

        http.post(url,dados);
}
}
