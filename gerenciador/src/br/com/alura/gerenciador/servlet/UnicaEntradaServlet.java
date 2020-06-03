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
import br.com.alura.gerenciador.acao.MostraFormNovaEmpresa;
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
			nome = mostraEmpresa.executa(request, response);	
			
		} else if(paramAcao.equals("alteraEmpresa")) {			
			AlteraEmpresa alteraEmpresa = new AlteraEmpresa();
			nome = alteraEmpresa.executa(request, response);
			
		} else if(paramAcao.equals("novaEmpresa")) {			
			NovaEmpresa novaEmpresa = new NovaEmpresa();
			nome = novaEmpresa.executa(request, response);
			
		} else if(paramAcao.equals("mostraFormNovaEmpresa")) {
			MostraFormNovaEmpresa mostraFormNovaEmpresa = new MostraFormNovaEmpresa();
			nome = mostraFormNovaEmpresa.executa(request, response);
		}
		
		String[] tipoEntradaEndereco = nome.split(":");
		
		if(tipoEntradaEndereco[0].equals("forward")) {
			//define para o despachador (dispatcher) para onde ele tem que despachar a requisição
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEntradaEndereco[1]);
			//envia de fato a requisição
			rd.forward(request, response);
			
			//O Tomcat "esconde" a pasta WEB-INF e não permite que alguma requisição via browser tenha acesso, 
			//pois há arquivos como o web.xml e os nossos JARs dentro desse diretório.
			//Sempre devemos "passar" pela ação antes de chamar o JSP, pois o JSP depende da ação. 
			//Esconder os JSPs na pasta WEB-INF reforça esse fluxo.
			
		} else {
			//Sends a temporary redirect response to the client using the specified redirect location URL and clears the buffer. 
			//The buffer will be replaced with the data set by this method.
			//Obs.: Enviando um redirect para o navegador fazer uma nova requisição para o servlet de entrada única, ou seja, o controlador central.  
			response.sendRedirect(tipoEntradaEndereco[1]);
		}
		
		
		
		
	}
}
