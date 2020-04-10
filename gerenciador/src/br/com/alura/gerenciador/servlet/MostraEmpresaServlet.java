package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.model.Banco;
import br.com.alura.gerenciador.model.Empresa;

@WebServlet("/mostraEmpresa")
public class MostraEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		Banco banco = new Banco(); 
		Empresa empresa = banco.buscaEmpresaPorId(id);
		
		//System.out.println("empresa selecionada: " + empresa.getNome());
		
		//Anexa um atributo na requisi��o
		request.setAttribute("empresa", empresa);
		//defini para o despachador (dispatcher) para onde ele tem que dispachar a requisi��o
		RequestDispatcher rd = request.getRequestDispatcher("/formEditaEmpresa.jsp");
		//envia de fato a requisi��o
		rd.forward(request, response);
		
	}

}
