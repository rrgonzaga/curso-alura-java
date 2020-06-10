package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.model.Banco;
import br.com.alura.gerenciador.model.Empresa;

/**
 * @author Rodrigo
 * A classe MostraEmpresa faz parte da camada do Controller. 
 * Ela tamb�m � chamada de Action/A��o e representa uma "extens�o" do controlador central.
 */
public class MostraEmpresa implements Acao {
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Mostrando dados da empresa");
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		Banco banco = new Banco(); 
		Empresa empresa = banco.buscaEmpresaPorId(id);
		
		//System.out.println("empresa selecionada: " + empresa.getNome());
		
		//Anexa um atributo na requisi��o
		request.setAttribute("empresa", empresa);
		
		return "forward:formEditaEmpresa.jsp";	
		
	}

}
