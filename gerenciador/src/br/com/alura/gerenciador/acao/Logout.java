package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession sessao = request.getSession();
		boolean usuarioLogado = sessao.getAttribute("usuarioLogado") != null;
		
		if(usuarioLogado) {
			//sessao.removeAttribute("usuarioLogado");
			
			//Invalidates this session then unbinds any objects bound to it.
			sessao.invalidate();
		}
		
		return "redirect:entrada?acao=MostraFormLogin";
	}
	

}
