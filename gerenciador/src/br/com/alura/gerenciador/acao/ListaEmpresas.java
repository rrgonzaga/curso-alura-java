package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.model.Banco;
import br.com.alura.gerenciador.model.Empresa;

/**
 * @author Rodrigo
 * A classe ListaEmpresas faz parte da camada do Controller. 
 * Ela também é chamada de Action/Ação e representa uma "extensão" do controlador central.
 */
public class ListaEmpresas {
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Listando empresa");
		
		Banco banco = new Banco();
		List<Empresa> empresas = banco.getEmpresas();
		
		//Anexa um atributo na requisição
		request.setAttribute("empresas", empresas);
		
		return "forward:/listaEmpresas.jsp";
		
	}

}
