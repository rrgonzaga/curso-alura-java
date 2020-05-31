package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.acao.AlteraEmpresa;
import br.com.alura.gerenciador.acao.ListaEmpresas;
import br.com.alura.gerenciador.acao.MostraEmpresa;
import br.com.alura.gerenciador.acao.NovaEmpresa;
import br.com.alura.gerenciador.acao.RemoveEmpresa;

@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String paramAcao = request.getParameter("acao");
		
		String nome = null;
		
		if(paramAcao.equals("listaEmpresas")) {					
			ListaEmpresas listaEmpresas = new ListaEmpresas();
			nome = listaEmpresas.executa(request, response);	
			
		} else if(paramAcao.equals("removeEmpresa")) {						
			RemoveEmpresa removeEmpresa = new RemoveEmpresa();
			nome = removeEmpresa.executa(request, response);		
			
		} else if(paramAcao.equals("mostraEmpresa")) {					
			MostraEmpresa mostraEmpresa = new MostraEmpresa();
			mostraEmpresa.executa(request, response);	
			
		} else if(paramAcao.equals("alteraEmpresa")) {			
			AlteraEmpresa alteraEmpresa = new AlteraEmpresa();
			alteraEmpresa.executa(request, response);
			
		} else if(paramAcao.equals("novaEmpresa")) {			
			NovaEmpresa novaEmpresa = new NovaEmpresa();
			novaEmpresa.executa(request, response);
		}
		
		String[] tipoEntradaEndereco = nome.split(":");
		
		if(tipoEntradaEndereco[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher(tipoEntradaEndereco[1]);		
			rd.forward(request, response);
		} else {
			response.sendRedirect(tipoEntradaEndereco[1]);
		}
		
		
		
		
	}
}
