package br.com.casadocodigo.loja.conf;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ServletSpringMVC extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {	
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {		
		//definindo que a classe AppWebConfiguration será usada como classe de configuração do servlet do SpringMVC
		return new Class[] {AppWebConfiguration.class, JPAConfiguration.class};
	}

	@Override
	protected String[] getServletMappings() {	
		//Estamos definindo que o servlet do SpringMVC atenderá as requisições a partir da raiz do nosso projeto (/)
		return new String[] {"/"};
	}

}
