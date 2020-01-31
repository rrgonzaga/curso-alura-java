package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.model.Banco;
import br.com.alura.gerenciador.model.Empresa;


@WebServlet("/listaEmpresas")
public class ListaEmpresasServlet extends HttpServlet {
	
	/**
	 * Aula 03 - Atividade 07 - Denifindo o nosso modelo de dados
	 * 
	 * O que foi aprendido: 
	 * O modelo ou dom�nio s�o as classes que representam o mundo real, aquilo que o cliente ou usu�rio da aplica��o define.
	 * Para descobrir quais s�o as classes e funcionalidades do modelo, 
	 * o analista de requisitos conversa com o cliente e documenta cada funcionalidade.
	 */
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		Banco banco = new Banco();
		List<Empresa> empresas = banco.getEmpresas();
		
		PrintWriter out = response.getWriter();
		
		/**
		 * Aula 04 - Atividade 08 - jsp para listar empresas
		 * 
		 * - Separa��o de responsabilidades fazendo com que o servlet n�o tenha c�digo HTML; 
		 * - Cria��o de JSP (Java Server Page) para renderizar c�digo est�tico (HTML) e c�digo din�mico (c�digo Java/Scriptlet).
		 * - Uso do objeto RequestDispatcher em um servlet para despachar/encaminhar uma requisi��o para o JSP 
		 * passando um atributo na requisi��o; 
		 * - JSP significa Java Server Pages;
		 * - JSP � uma p�gina automaticamente processada pelo Tomcat;
		 * - Para gerar HTML dinamicamente no JSP usamos Scriplets; 
		 * - Um scriptlet <% %> � um c�digo Java dentro do HTML; 
		 * - Um scriptlet s� funciona em uma p�gina JSP; 
		 * - Usamos o RequestDispatcher para chamar um JSP a partir da servlet; 
		 * - Obtemos o RequestDispatcher a partir do HttpServletRequest;
		 * - Usamos a requisi��o para colocar ou pegar um atributo (setAttribute(.., ..) ou getAttribute(..)).
		 */
		
		request.setAttribute("empresas", empresas);
		
		//Returns a RequestDispatcher object that acts as a wrapper for the resource located at the given path. 
		//A RequestDispatcher object can be used to forward a request to the resource or to include the resource in a response. 
		//The resource can be dynamic or static. 
		
		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas.jsp");
		//Forwards a request from a servlet to another resource (servlet, JSP file, or HTML file) on the server.
		rd.forward(request, response);	
		
		
	}

}
