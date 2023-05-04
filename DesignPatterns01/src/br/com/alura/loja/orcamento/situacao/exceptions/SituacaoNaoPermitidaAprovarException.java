package br.com.alura.loja.orcamento.situacao.exceptions;

public class SituacaoNaoPermitidaAprovarException extends RuntimeException {
    static final long serialVersionUID = 1L;
    public SituacaoNaoPermitidaAprovarException(String descricaoSituacao) {
        super("Situação do orçamento: \"" + descricaoSituacao + "\" não permitida para aprovar");
    }
}
