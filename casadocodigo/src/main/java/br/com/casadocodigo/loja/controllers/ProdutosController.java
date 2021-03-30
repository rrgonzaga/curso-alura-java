package br.com.casadocodigo.loja.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.loja.daos.ProdutoDAO;
import br.com.casadocodigo.loja.infra.FileSaver;
import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.models.TipoPreco;
import br.com.casadocodigo.loja.validation.ProdutoValidation;

@Controller
@RequestMapping("/produtos")
public class ProdutosController {
	
	@Autowired
	private ProdutoDAO produtoDAO;
	
	@Autowired
	private FileSaver fileSaver;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new ProdutoValidation());		
	}
	
	@RequestMapping("/form")
	public ModelAndView form(Produto produto) {
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
	public ModelAndView gravar(MultipartFile sumario, @Valid Produto produto, BindingResult result, RedirectAttributes redirectAttributes) {
		if(result.hasErrors()) {
			return this.form(produto);
		}
		
		String path = fileSaver.write("arquivos-sumario", sumario);
		produto.setSumarioPath(path);
		
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
	
	@RequestMapping("/detalhe/{id}")
	public ModelAndView detalhe(@PathVariable("id") Integer id) {
		ModelAndView modelAndView = new ModelAndView("produtos/detalhe");
		Produto produto = produtoDAO.find(id);
		modelAndView.addObject("produto", produto);		
		
		return modelAndView;	
	}

}
