package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.acao.Acao;
/**
 * @author Rodrigo
 * Este sevlet de entrada �nica foi substituido pela classe de filtro ControladorFilter  
 *
 */
//@WebServlet(urlPatterns = "/entrada")
//@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramAcao = request.getParameter("acao");
				
		String nomeClasse = "br.com.alura.gerenciador.acao." + paramAcao;
		
		String nome;
		
		try {
			//Carrega uma determinada classe em mem�ria. 
			//A classe a ser carregada � a classe com o nome que foi passado por par�mtro para o m�todo forName.
			Class classe = Class.forName(nomeClasse);
			Acao acao = (Acao) classe.newInstance();		
			nome = acao.executa(request,response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}
		
		String[] tipoEntradaEndereco = nome.split(":");
		
		if(tipoEntradaEndereco[0].equals("forward")) {
			//define para o despachador (dispatcher) para onde ele tem que despachar a requisi��o
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEntradaEndereco[1]);
			//envia de fato a requisi��o
			rd.forward(request, response);
			
			//O Tomcat "esconde" a pasta WEB-INF e n�o permite que alguma requisi��o via browser tenha acesso, 
			//pois h� arquivos como o web.xml e os nossos JARs dentro desse diret�rio.
			//Sempre devemos "passar" pela a��o antes de chamar o JSP, pois o JSP depende da a��o. 
			//Esconder os JSPs na pasta WEB-INF refor�a esse fluxo.
			
		} else {
			//Sends a temporary redirect response to the client using the specified redirect location URL and clears the buffer. 
			//The buffer will be replaced with the data set by this method.
			//Obs.: Enviando um redirect para o navegador fazer uma nova requisi��o para o servlet de entrada �nica, ou seja, o controlador central.  
			response.sendRedirect(tipoEntradaEndereco[1]);
		}
		
		
//		if(paramAcao.equals("ListaEmpresas")) {					
//			ListaEmpresas listaEmpresas = new ListaEmpresas();
//			nome = listaEmpresas.executa(request, response);	
//			
//		} else if(paramAcao.equals("RemoveEmpresa")) {						
//			RemoveEmpresa removeEmpresa = new RemoveEmpresa();
//			nome = removeEmpresa.executa(request, response);		
//			
//		} else if(paramAcao.equals("MostraEmpresa")) {					
//			MostraEmpresa mostraEmpresa = new MostraEmpresa();
//			nome = mostraEmpresa.executa(request, response);	
//			
//		} else if(paramAcao.equals("AlteraEmpresa")) {			
//			AlteraEmpresa alteraEmpresa = new AlteraEmpresa();
//			nome = alteraEmpresa.executa(request, response);
//			
//		} else if(paramAcao.equals("NovaEmpresa")) {			
//			NovaEmpresa novaEmpresa = new NovaEmpresa();
//			nome = novaEmpresa.executa(request, response);
//			
//		} else if(paramAcao.equals("MostraFormNovaEmpresa")) {
//			MostraFormNovaEmpresa mostraFormNovaEmpresa = new MostraFormNovaEmpresa();
//			nome = mostraFormNovaEmpresa.executa(request, response);
//		}	
		
	}
}
