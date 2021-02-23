package br.com.casadocodigo.loja.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.loja.daos.ProdutoDAO;
import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.models.TipoPreco;

@Controller
@RequestMapping("/produtos")
public class ProdutosController {
	
	@Autowired
	private ProdutoDAO produtoDAO;
	
	@RequestMapping("/form")
	public ModelAndView form() {
		ModelAndView modelAndView = new ModelAndView("produtos/form");
		modelAndView.addObject("tipos", TipoPreco.values());		
		return modelAndView;
	}
	
	/**
	 * 
	 * @param produto
	 * @param redirectAttributes
	 * @return
	 * @note O Flash Scoped é um escopo onde os objetos que adicionamos nele através do método addFlashAttribute ficam 
	 * disponíveis de um request para outro, enquanto o navegador executa um redirect (usando o código de status 302).
	 */
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView gravar(Produto produto, RedirectAttributes redirectAttributes) {
		System.out.println("produto: " + produto);
		produtoDAO.gravar(produto);
		redirectAttributes.addFlashAttribute("sucesso", "Produto cadastrado com sucesso!");
		
		//Boa prática: para evitar qualquer problema de dados reenviados, realizamos um redirect após o envio de um formulário com POST
		return new ModelAndView("redirect:produtos");
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView listar() {		
		ModelAndView modelAndView = new ModelAndView("produtos/lista");		
		List<Produto> produtos = produtoDAO.listar();
		modelAndView.addObject("produtos",produtos);
		
		return modelAndView;
	}

}
