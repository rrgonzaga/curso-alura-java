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
 * Ela também é chamada de Action/Ação e representa uma "extensão" do controlador central.
 */
public class MostraEmpresa {
	
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Mostrando dados da empresa");
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		Banco banco = new Banco(); 
		Empresa empresa = banco.buscaEmpresaPorId(id);
		
		//System.out.println("empresa selecionada: " + empresa.getNome());
		
		//Anexa um atributo na requisição
		request.setAttribute("empresa", empresa);
		//defini para o despachador (dispatcher) para onde ele tem que dispachar a requisição
		RequestDispatcher rd = request.getRequestDispatcher("/formEditaEmpresa.jsp");
		//envia de fato a requisição
		rd.forward(request, response);
		
		
	}

}
