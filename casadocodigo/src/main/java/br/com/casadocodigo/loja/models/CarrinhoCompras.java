package br.com.casadocodigo.loja.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 * 
 * @author Rodrigo
 * @see A anotação @Scope serve para mudar o escopo do Controller 
 * e o atributo proxyMode serve para o Spring criar um proxy envolvendo o objeto alvo (TARGET_CLASS) 
 * afim de possibilitar que as informações do objeto da classe alvo possam ser transitadas de um escopo para outro.
 * Assim será possível fazer com que o objeto da classe CarrinhoCompras seja acessível dentro dos Controllers sem ter 
 * que mudar o escopo dos outros Controllers que precisam utilizar o objeto carrinho de compras. 
 */
@Component
@Scope(value=WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CarrinhoCompras implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Map<CarrinhoItem, Integer> itens = new LinkedHashMap<>(); 
	

	public Collection<CarrinhoItem> getItens() {
		return itens.keySet();
	}

	public void add(CarrinhoItem item) {
		itens.put(item, getQuantidade(item) + 1);
		
	}

	public Integer getQuantidade(CarrinhoItem item) {		
		if(!itens.containsKey(item)) {
			itens.put(item, 0);
		}
		return itens.get(item);
	}
	
	public int getQuantidade() {
		return itens.values().stream()
				.reduce(0, (proximo, acumulador) -> proximo + acumulador);
	}
	
	public BigDecimal getTotal(CarrinhoItem item) {
		return item.getTotal(getQuantidade(item));
	}
	
	public BigDecimal getTotal() {
		BigDecimal total = BigDecimal.ZERO;
		for (CarrinhoItem item : itens.keySet()) {
			total = total.add(getTotal(item));
		}
		return total;
	}

	public void remover(Integer produtoId, TipoPreco tipoPreco) {
		Produto produto = new Produto();
		produto.setId(produtoId);
		
		itens.remove(new CarrinhoItem(produto,tipoPreco));
		
	}
	
	public void removerTodosItens() {
		itens.clear();
	}
	
	
	

	
}
