package br.com.alura.loja.orcamento.situacao;

import br.com.alura.loja.enumerations.Situacao;
import br.com.alura.loja.orcamento.Orcamento;

public class Finalizado extends SituacaoOrcamento {

    @Override
    public String getDescricao() {
        return Situacao.FINALIZADO.getDescricao();
    }

    @Override
    public void encerrar(Orcamento orcamento) {
        orcamento.setSituacao(new Encerrado());
    }

    @Override
    public void analisar(Orcamento orcamento) {
        orcamento.setSituacao(new EmAnalise());
    }
}
