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
	 * Aula 02 - Atividade 02 - Enviando par�metros
	 * 
	 * O que foi aprendido: 
	 * Chamamos o Servlet NovaEmpresaServlet atrav�s do navegador; 
	 * Enviamos um par�metro na requisi��o chamado nome; 
	 * Lemos esse par�metro no m�todo service atrav�s do objeto request, m�todo getParameter
	 * Por �ltimo, concatenamos o valor do par�metro nome com a resposta exibida no navegador. 
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Aula 02 - Atividade 07 - Apenas POST
	 * 
	 * O que foi aprendido: 
	 * Restringindo a chamada de um m�todo de um servlet para apenas POST com doPost
	 * OBS.: N�o h� suporte para maiores especificidades no m�todo service(), 
	 * ele sempre aceitar� as duas requisi��es de forma indiscriminada. 
	 * Recorreremos a outro m�todo que aceita apenas requisi��es POST, doPost(). 
	 * Caso fosse do nosso interesse receber apenas requisi��es GET, usar�amos o m�todo doGet().
	 * 
	 * O "Erro 405", no mundo do HTTP, significa a requisi��o (URL) � conhecida pelo servido mas 
	 * que o m�todo da requisi��o (GET ou POST ou o outro m�todo da requisi��o) n�o � permitido pelo servidor.
	 * 
	 */
	
	/**
	 * Aula 04 - Atividade 06 - RequestDispatcher
	 * 
	 * - Separa��o de responsabilidades fazendo com que o servlet n�o tenha c�digo HTML; 
	 * - Cria��o de JSP (Java Server Page) para renderizar c�digo est�tico (HTML) e c�digo din�mico (c�digo Java/Scriptlet).
	 * - Uso do objeto RequestDispatcher em um servlet para despachar/encaminhar uma requisi��o para o JSP 
	 * passando um atributo na requisi��o. 
	 * -M�todo que oferece suporte apenas para o tipo POST.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nomeEmpresa = request.getParameter("nome");
		String strDataAbertura = request.getParameter("dataAbertura");
		
		Date dataAbertura = null;
		
		try {
			//Usando a classe SimpleDateFormat para fazer o parsing da data que veio do formul�rio
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
		
		//definindo um atributo e seu valor na requisi��o
		request.setAttribute("empresa", empresa.getNome());
		
		//Call the JSP - Java Server Page
		
		// A RequestDispatcher object can be used to forward a request to the resource or to include the resource in a response.
//		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas");		
//		rd.forward(request, response);
		
		/**
		 * Aula 06 - Atividade 05 - Redirecionamento pelo navegador
		 * 
		 * - Resolvendo o seguinte problema: os Servlets foram chamados, o arquivo JSP e tudo isso em uma mesma requisi��o. 
		 * Trata-se de uma m� pr�tica que gera problemas em nossa aplica��o, como o cadastro de dados id�nticos em nosso 
		 * banco de dados. 
		 * - Uso do Redirecionamento Client Side, isto �, "do lado do cliente". Quando utilizamos despachadores de um Servlet 
		 * para outro, esse processo � denominado Redirecionamento Server Side, "do lado do servidor;
		 * - Uso do objeto response e do m�todo sendRedirect() para devolver uma resposta para o navegador com um novo endere�o, 
		 * o endere�o do servlet de listaEmpresasServlet e assim o navegador far� uma nova requisi��o para o novo endere�o. 
		 * - OBS.1: Ap�s uma opera��o de escrita ser realiza, podemos redirecionar o navegador que realizar� uma nova requisi��o, 
		 * no caso de leitura. Se o usu�rio pressionar F5, o navegador repetir� a opera��o de leitura.
		 * - OBS.2: O c�digo de resposta para redirecionamento HTTP � 30X (301 ou 302).  
		
		 */
		
		//Redirecionando pelo navegador
		//Sends a temporary redirect response to the client using the specified redirect location URL and clears the buffer. 
		//The buffer will be replaced with the data set by this method.
		response.sendRedirect("listaEmpresas");
		
		
		
	}
	
	

}
