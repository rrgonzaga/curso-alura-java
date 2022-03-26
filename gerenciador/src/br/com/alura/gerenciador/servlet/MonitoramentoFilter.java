package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

//@WebFilter(urlPatterns="/entrada")
public class MonitoramentoFilter implements Filter {
	
	//Implementa��o dos m�todos init e destroy para deploy no servidor Jetty
		@Override
		public void destroy() {
			
		}

		@Override
		public void init(FilterConfig filterConfig) throws ServletException {
			
		}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		long tempoInicial = System.currentTimeMillis();
		
		System.out.println("MonitoramentoFilter");
		
		String acao = request.getParameter("acao");
		
		//executa a a��o
		chain.doFilter(request, response);		
		
		long tempoFinal = System.currentTimeMillis();
		System.out.println("Tempo de execu��o da a��o '" + acao + "' em " + (tempoFinal - tempoInicial) + " ms");		
	}
}
