package br.com.casadocodigo.loja.controllers;

import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.loja.models.CarrinhoCompras;
import br.com.casadocodigo.loja.models.DadosPagamento;

/**
 * A classe RestTemplate é a classe responsável por fazer integrações entre sistemas, ou seja, enviar requisições de uma aplicação 
 * para outra aplicação independente do navegador.  
 * @author Rodrigo
 *
 */
@RequestMapping("/pagamento")
@Controller
@Scope(value=WebApplicationContext.SCOPE_REQUEST)
public class PagamentoController {
	
	@Autowired
	private CarrinhoCompras carrinho;
	
	@Autowired
	private RestTemplate restTemplate;
	
	/**
	 * Uso da classe Callable para fazer chamadas assíncronas para finalizar pagamentos. Desta forma somente o usuário que 
	 * requisitou a finalização do pagamento aguardará a resposta do processamento. Os demais usuários continuarão usando a 
	 * apliação sem nenhum problema ou espera de finalização do pagamento. 
	 * Observação: Foi usado um dos recursos do Java 8. Esta forma de usar lambda nos permite criar um objeto do mesmo tipo esperado 
	 * pelo retorno do método, evitando que criemos uma classe anônima. 
	 * Neste caso é perfeitamente aplicável o recurso, porque na interface Callable só há um método, de nome call.
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value="/finalizar", method=RequestMethod.POST)
	public Callable<ModelAndView> finalizar(RedirectAttributes redirectAttributes) {
		
		return() -> {
			
			String uri = "http://book-payment.herokuapp.com/payment";
			
			try {
				// Parâmetros do método postForObject: O primeiro deles é a url na qual queremos enviar a requisição, 
				// o segundo é o objeto que representa a mensagem (o corpo) da requisição 
				// e por último uma classe na qual esperamos receber uma resposta do tipo.
				String response = restTemplate.postForObject(uri, new DadosPagamento(carrinho.getTotal()), String.class);		
				System.out.println(response);	
				redirectAttributes.addFlashAttribute("sucesso", response);
				carrinho.removerTodosItens();
			} catch (HttpClientErrorException e) {
				//e.printStackTrace();
				redirectAttributes.addFlashAttribute("falha", "Valor maior que o permitido");
			}
			
			return new ModelAndView("redirect:/produtos");
		};		
	}
}
