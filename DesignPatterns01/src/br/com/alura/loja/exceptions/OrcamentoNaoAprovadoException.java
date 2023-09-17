package br.com.alura.loja.exceptions;

public class OrcamentoNaoAprovadoException extends RuntimeException {
    public OrcamentoNaoAprovadoException(){
        super("Orçamento não está aprovado");
    }
    public OrcamentoNaoAprovadoException(String message) {
        super(message);
    }
}