package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.acao.Acao;

/**
 * Servlet Filter implementation class AutorizacaoFilter
 */
//@WebFilter("/entrada")
public class ControladorFilter implements Filter {
	
	//Implementa��o dos m�todos init e destroy para deploy no servidor Jetty
		@Override
		public void destroy() {
			
		}

		@Override
		public void init(FilterConfig filterConfig) throws ServletException {
			
		}
	
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("ControladorFilter");
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		String paramAcao = request.getParameter("acao");
		
		String nomeClasse = "br.com.alura.gerenciador.acao." + paramAcao;
		
		String nome;
		
		try {
			//Carrega uma determinada classe em mem�ria. 
			//A classe a ser carregada � a classe com o nome que foi passado por par�mtro para o m�todo forName.
			Class classe = Class.forName(nomeClasse);
			Acao acao = (Acao) classe.newInstance();		
			nome = acao.executa(request,response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}
		
		String[] tipoEntradaEndereco = nome.split(":");
		
		if(tipoEntradaEndereco[0].equals("forward")) {
			//define para o despachador (dispatcher) para onde ele tem que despachar a requisi��o
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEntradaEndereco[1]);
			//envia de fato a requisi��o
			rd.forward(request, response);
			
			//O Tomcat "esconde" a pasta WEB-INF e n�o permite que alguma requisi��o via browser tenha acesso, 
			//pois h� arquivos como o web.xml e os nossos JARs dentro desse diret�rio.
			//Sempre devemos "passar" pela a��o antes de chamar o JSP, pois o JSP depende da a��o. 
			//Esconder os JSPs na pasta WEB-INF refor�a esse fluxo.
			
		} else {
			//Sends a temporary redirect response to the client using the specified redirect location URL and clears the buffer. 
			//The buffer will be replaced with the data set by this method.
			//Obs.: Enviando um redirect para o navegador fazer uma nova requisi��o para o servlet de entrada �nica, ou seja, o controlador central.  
			response.sendRedirect(tipoEntradaEndereco[1]);
		}
	}

}
