package br.com.alura.loja.orcamento.situacao.exceptions;

public class SituacaoNaoPermitidaReprovarException extends RuntimeException {
    static final long serialVersionUID = 1L;
    public SituacaoNaoPermitidaReprovarException(String descricaoSituacao) {
        super("Situação do orçamento: \"" + descricaoSituacao + "\" não permitida para reprovar");
    }
}
