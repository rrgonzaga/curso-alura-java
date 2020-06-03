package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.model.Banco;
import br.com.alura.gerenciador.model.Empresa;

/**
 * @author Rodrigo
 * A classe MostraFormNovaEmpresa faz parte da camada do Controller. 
 * Ela também é chamada de Action/Ação e representa uma "extensão" do controlador central.
 */
public class MostraFormNovaEmpresa {
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		System.out.println("Mostra formulário nova empresa");					
			
		return "forward:formNovaEmpresa.jsp";			
	}

}
