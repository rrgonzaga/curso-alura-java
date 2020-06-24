package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Rodrigo
 * A classe Login faz parte da camada do Controller. 
 * Ela tamb�m � chamada de Action/A��o e representa uma "extens�o" do controlador central.
 */
public class Login implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		System.out.println("Logando " + login);
		
		
		
		
		
		return "redirect:entrada?acao=ListaEmpresas";
	}

}
