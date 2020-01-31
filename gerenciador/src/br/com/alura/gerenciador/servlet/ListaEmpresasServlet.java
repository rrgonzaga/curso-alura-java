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
	 * O modelo ou domínio são as classes que representam o mundo real, aquilo que o cliente ou usuário da aplicação define.
	 * Para descobrir quais são as classes e funcionalidades do modelo, 
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
		 * - Separação de responsabilidades fazendo com que o servlet não tenha código HTML; 
		 * - Criação de JSP (Java Server Page) para renderizar código estático (HTML) e código dinâmico (código Java/Scriptlet).
		 * - Uso do objeto RequestDispatcher em um servlet para despachar/encaminhar uma requisição para o JSP 
		 * passando um atributo na requisição; 
		 * - JSP significa Java Server Pages;
		 * - JSP é uma página automaticamente processada pelo Tomcat;
		 * - Para gerar HTML dinamicamente no JSP usamos Scriplets; 
		 * - Um scriptlet <% %> é um código Java dentro do HTML; 
		 * - Um scriptlet só funciona em uma página JSP; 
		 * - Usamos o RequestDispatcher para chamar um JSP a partir da servlet; 
		 * - Obtemos o RequestDispatcher a partir do HttpServletRequest;
		 * - Usamos a requisição para colocar ou pegar um atributo (setAttribute(.., ..) ou getAttribute(..)).
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
