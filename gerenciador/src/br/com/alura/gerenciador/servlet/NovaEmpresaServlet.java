package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.model.Banco;
import br.com.alura.gerenciador.model.Empresa;

/**
 * Servlet implementation class NovaEmpresaServlet
 */
@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	
	/**
	 * Aula 02 - Atividade 02 - Enviando parâmetros
	 * 
	 * O que foi aprendido: 
	 * Chamamos o Servlet NovaEmpresaServlet através do navegador; 
	 * Enviamos um parâmetro na requisição chamado nome; 
	 * Lemos esse parâmetro no método service através do objeto request, método getParameter
	 * Por último, concatenamos o valor do parâmetro nome com a resposta exibida no navegador. 
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Aula 02 - Atividade 07 - Apenas POST
	 * 
	 * O que foi aprendido: 
	 * Restringindo a chamada de um método de um servlet para apenas POST com doPost
	 * OBS.: Não há suporte para maiores especificidades no método service(), 
	 * ele sempre aceitará as duas requisições de forma indiscriminada. 
	 * Recorreremos a outro método que aceita apenas requisições POST, doPost(). 
	 * Caso fosse do nosso interesse receber apenas requisições GET, usaríamos o método doGet().
	 * 
	 * O "Erro 405", no mundo do HTTP, significa a requisição (URL) é conhecida pelo servido mas 
	 * que o método da requisição (GET ou POST ou o outro método da requisição) não é permitido pelo servidor.
	 * 
	 */
	
	/**
	 * Aula 04 - Atividade 06 - RequestDispatcher
	 * 
	 * - Separação de responsabilidades fazendo com que o servlet não tenha código HTML; 
	 * - Criação de JSP (Java Server Page) para renderizar código estático (HTML) e código dinâmico (código Java/Scriptlet).
	 * - Uso do objeto RequestDispatcher em um servlet para despachar/encaminhar uma requisição para o JSP 
	 * passando um atributo na requisição. 
	 * -Método que oferece suporte apenas para o tipo POST.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nomeEmpresa = request.getParameter("nome");
		String strDataAbertura = request.getParameter("dataAbertura");
		
		Date dataAbertura = null;
		
		try {
			//Usando a classe SimpleDateFormat para fazer o parsing da data que veio do formulário
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			//Parses text from the beginning of the given string to produce a date.
			dataAbertura = sdf.parse(strDataAbertura);
		} catch (ParseException e) {
			//usando o pattern catch and rethrow
			throw new ServletException(e);
		}
		
		Empresa empresa = new Empresa();
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dataAbertura);
		
		Banco banco = new Banco();
		banco.adiciona(empresa);
		
//		PrintWriter writer = response.getWriter();
//		writer.println("<HTML>");
//		writer.println("<Body>");
//		writer.println("<span> Empresa " + nomeEmpresa + " cadastrada com sucesso </span>");
//		writer.println("</Body>");		
//		writer.println("</HTML>");		
//		
		System.out.println("Empresa " + nomeEmpresa + " cadastrada com sucesso");
		
		//Call the JSP - Java Server Page
		
		// A RequestDispatcher object can be used to forward a request to the resource or to include the resource in a response.
		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas");
		request.setAttribute("empresa", empresa.getNome());		
		rd.forward(request, response);
		
	}
	
	

}
