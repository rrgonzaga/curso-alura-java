package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
		
		out.println("<HTML>");
		out.println("<Body>");
		out.println("<ul>");
		
		for(Empresa empresa : empresas) {
			out.println("<li>"+ empresa.getNome() + "</li>");
		}
		
		out.println("</ul>");
		out.println("</Body>");		
		out.println("</HTML>");
		
		
		
		
		
		
	}

}
