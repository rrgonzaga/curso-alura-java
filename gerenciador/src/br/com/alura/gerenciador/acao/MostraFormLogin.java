package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Rodrigo
 * A classe MostraFormLogin faz parte da camada do Controller. 
 * Ela tamb�m � chamada de Action/A��o e representa uma "extens�o" do controlador central.
 */
public class MostraFormLogin implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("Mostra formul�rio login");		
		
		return "forward:formLogin.jsp";
	}

}
