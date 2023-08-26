package br.com.alura.loja.exceptions;

public class DadosInsuficientesCriacaoPedidoException extends RuntimeException{
    public DadosInsuficientesCriacaoPedidoException(String mensagem){
        super(mensagem);
    }
}

