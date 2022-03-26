package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.model.Banco;

/**
 * @author Rodrigo
 * A classe RemoveEmpresa faz parte da camada do Controller. 
 * Ela tamb�m � chamada de Action/A��o e representa uma "extens�o" do controlador central.
 */
public class RemoveEmpresa implements Acao {
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		System.out.println("Removendo empresa");
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);		
		//System.out.println(id);
		
		Banco banco = new Banco();
		banco.removeEmpresa(id);		
		
		return "redirect:entrada?acao=ListaEmpresas";			
	}

}
