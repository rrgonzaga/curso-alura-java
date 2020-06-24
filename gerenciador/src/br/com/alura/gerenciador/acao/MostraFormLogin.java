package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Rodrigo
 * A classe MostraFormLogin faz parte da camada do Controller. 
 * Ela também é chamada de Action/Ação e representa uma "extensão" do controlador central.
 */
public class MostraFormLogin implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("Mostra formulário login");		
		
		return "forward:formLogin.jsp";
	}

}
