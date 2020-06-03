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
 * Ela tamb�m � chamada de Action/A��o e representa uma "extens�o" do controlador central.
 */
public class MostraFormNovaEmpresa {
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		System.out.println("Mostra formul�rio nova empresa");					
			
		return "forward:formNovaEmpresa.jsp";			
	}

}
