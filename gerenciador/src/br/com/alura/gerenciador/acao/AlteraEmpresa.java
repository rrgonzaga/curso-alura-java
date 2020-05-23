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
 * A classe AlteraEmpresa faz parte da camada do Controller. 
 * Ela também é chamada de Action/Ação e representa uma "extensão" do controlador central.
 */
public class AlteraEmpresa {
	
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		System.out.println("Alterando empresa");
		
		String paramId = request.getParameter("id");
		String nomeEmpresa = request.getParameter("nome");
		String strDataAbertura = request.getParameter("dataAbertura");
		
		Integer id = Integer.valueOf(paramId);
		
		Date dataAbertura = null;
		
		try {
			//Usando a classe SimpleDateFormat para fazer o parsing da data que veio do formulário
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			//Parses text from the beginning of the given string to produce a date.
			dataAbertura = sdf.parse(strDataAbertura);
		} catch (ParseException e) {
			//usando o pattern catch and rethrow
			throw new ServletException(e);
		}
		
		System.out.println("id empresa: " + id);		
		
		Banco banco = new Banco();
		
		Empresa empresa = banco.buscaEmpresaPorId(id);
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dataAbertura);
		
		//Enviando um redirect para o navegador fazer uma nova requisição para o servlet de listar empresas 
		response.sendRedirect("entrada?acao=listaEmpresas");			
	}

}
