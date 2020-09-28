package br.com.casadocodigo.loja.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import br.com.casadocodigo.loja.controllers.HomeController;

@EnableWebMvc
@ComponentScan(basePackageClasses= {HomeController.class})
public class AppWebConfiguration {
	
	/*
	 * A anotação @Bean é para que o retorno da chamada deste método possa ser gerenciada pelo SpringMVC, 
	 * sem ela nossa configuração não funciona.
	 */
	
	/**
	 * Método responsável por indicar em qual diretório as views estão disponíveis
	 * @return
	 */
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");		
		
		return resolver;
	}

}
