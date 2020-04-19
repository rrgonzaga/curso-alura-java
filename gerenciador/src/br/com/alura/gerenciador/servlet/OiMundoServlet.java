package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/oi", loadOnStartup=1)
public class OiMundoServlet extends HttpServlet {
	
	public OiMundoServlet() {
		System.out.println("Criando Oi Mundo Servlet"); 
	}
	
	/**
	 * Aula 02 - Atividade 01 - Meu primeiro servlet
	 * 
	 * O que foi aprendido: 
	 * Apache Tomcat ou apenas Tomcat � um servidor web em Java;
	 * Tomcat entende o protocolo HTTP e roda por padr�o no http://localhost:8080;
	 * O projeto Java faz parte da URL, no nosso caso: http://localhost:8080/gerenciador;
	 * Uma aplica��o web Java pode ter p�ginas HTML;
	 * Uma servlet � um objeto Java que podemos chamar a partir de uma requisi��o HTTP;
	 * Para mapear a URL para uma servlet usamos a anota��o @WebServlet
	 * Uma servlet deve estender a classe HttpServlet e sobrescrever um determinado m�todo (por exemplo service).
	 */
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		PrintWriter writer = resp.getWriter();
		writer.println("<HTML>");
		writer.println("<body>");
		writer.println("<div>");
		writer.println("Oi mundo, este � o meu primeiro servlet.");
		writer.println("</div>");
		writer.println("</body>");
		writer.println("</HTML>");
		
		System.out.println("O servlet OiMundoServlet foi chamado.");
	}

}
