package br.com.alura.loja.enumerations;

public enum Situacao {
    EM_ELABORACAO ("Em elaboração"),
    FINALIZADO("Finalizado"),
    ENCERRADO ("Encerrado"),
    EM_ANALISE ("Em análise"),
    APROVADO ("Aprovado"),
    REPROVADO ("Reprovado");

    private final String descricao;

    Situacao(String desc) {
        this.descricao = desc;
    }

    public String getDescricao() {
        return descricao;
    }
}
