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
	
	//Implementação dos métodos init e destroy para deploy no servidor Jetty
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
			//Carrega uma determinada classe em memória. 
			//A classe a ser carregada é a classe com o nome que foi passado por parâmtro para o método forName.
			Class classe = Class.forName(nomeClasse);
			Acao acao = (Acao) classe.newInstance();		
			nome = acao.executa(request,response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}
		
		String[] tipoEntradaEndereco = nome.split(":");
		
		if(tipoEntradaEndereco[0].equals("forward")) {
			//define para o despachador (dispatcher) para onde ele tem que despachar a requisição
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEntradaEndereco[1]);
			//envia de fato a requisição
			rd.forward(request, response);
			
			//O Tomcat "esconde" a pasta WEB-INF e não permite que alguma requisição via browser tenha acesso, 
			//pois há arquivos como o web.xml e os nossos JARs dentro desse diretório.
			//Sempre devemos "passar" pela ação antes de chamar o JSP, pois o JSP depende da ação. 
			//Esconder os JSPs na pasta WEB-INF reforça esse fluxo.
			
		} else {
			//Sends a temporary redirect response to the client using the specified redirect location URL and clears the buffer. 
			//The buffer will be replaced with the data set by this method.
			//Obs.: Enviando um redirect para o navegador fazer uma nova requisição para o servlet de entrada única, ou seja, o controlador central.  
			response.sendRedirect(tipoEntradaEndereco[1]);
		}
	}

}
