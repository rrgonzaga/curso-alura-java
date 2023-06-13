package br.com.alura.loja.orcamento.situacao;

import br.com.alura.loja.enumerations.Situacao;
import br.com.alura.loja.orcamento.Orcamento;

public class EmElaboracao extends SituacaoOrcamento {
    @Override
    public String getDescricao() {
        return Situacao.EM_ELABORACAO.getDescricao();
    }

    @Override
    public void finalizar(Orcamento orcamento) {
        orcamento.setSituacao(new Finalizado());
    }

    @Override
    public void encerrar(Orcamento orcamento) {
        orcamento.setSituacao(new Encerrado());
    }
}
