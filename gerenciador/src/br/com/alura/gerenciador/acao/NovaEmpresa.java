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


public class NovaEmpresa {
	
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		System.out.println("Criando empresa");
		
		String nomeEmpresa = request.getParameter("nome");
		String strDataAbertura = request.getParameter("dataAbertura");
		
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
		
		Empresa empresa = new Empresa();
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dataAbertura);
		
		Banco banco = new Banco();
		banco.adiciona(empresa);		

		System.out.println("Empresa " + nomeEmpresa + " cadastrada com sucesso");		
		
		//definindo um atributo e seu valor na requisição
		request.setAttribute("empresa", empresa.getNome());		
		
		//Redirecionando pelo navegador
		//Sends a temporary redirect response to the client using the specified redirect location URL and clears the buffer. 
		//The buffer will be replaced with the data set by this method.
		response.sendRedirect("entrada?acao=listaEmpresas");			
	}

}
