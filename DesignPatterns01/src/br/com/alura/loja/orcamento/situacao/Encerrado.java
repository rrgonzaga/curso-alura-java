package br.com.alura.loja.orcamento.situacao;

import br.com.alura.loja.enumerations.Situacao;

public class Encerrado extends SituacaoOrcamento {
    @Override
    public String getDescricao() {
        return Situacao.ENCERRADO.getDescricao();
    }
}
