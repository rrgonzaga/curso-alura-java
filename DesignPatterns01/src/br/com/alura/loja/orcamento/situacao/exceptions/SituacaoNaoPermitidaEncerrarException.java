package br.com.alura.loja.orcamento.situacao.exceptions;

public class SituacaoNaoPermitidaEncerrarException extends RuntimeException {
    static final long serialVersionUID = 1L;
    public SituacaoNaoPermitidaEncerrarException(String descricaoSituacao) {
        super("Situação do orçamento: \"" + descricaoSituacao + "\" não permitida para encerrar");
    }
}
