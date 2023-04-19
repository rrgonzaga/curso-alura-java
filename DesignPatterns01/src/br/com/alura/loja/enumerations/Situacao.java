package br.com.alura.loja.enumerations;

public enum Situacao {
    EM_ANALISE ("Em análise"),
    APROVADO ("Aprovado");

    private final String descricao;

    Situacao(String desc) {
        this.descricao = desc;
    }

    public String getDescricao() {
        return descricao;
    }
}
