package br.com.alura.loja.orcamento.situacao.exceptions;

public class SituacaoNaoPermitidaElaborarException extends RuntimeException {
    static final long serialVersionUID = 1L;
    public SituacaoNaoPermitidaElaborarException(String descricaoSituacao) {
        super("Situação do orçamento: \"" + descricaoSituacao + "\" não permitida para elaborar");
    }
}
