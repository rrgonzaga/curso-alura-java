package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.model.Banco;
import br.com.alura.gerenciador.model.Empresa;

/**
 * @author Rodrigo
 * A classe ListaEmpresas faz parte da camada do Controller. 
 * Ela também é chamada de Action/Ação e representa uma "extensão" do controlador central.
 */
public class ListaEmpresas implements Acao {
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
		System.out.println("Listando empresa");
		
		Banco banco = new Banco();
		List<Empresa> empresas = banco.getEmpresas();
		
//		Compares two strings lexicographically. 
//		The comparison is based on the Unicode value of each character in the strings. 
//		The character sequence represented by this String object is compared lexicographically 
//		to the character sequence represented by the argument string. 
//		The result is a negative integer if this String object lexicographically precedes the argument string. 
//		The result is a positive integer if this String object lexicographically follows the argument string. 
//		The result is zero if the strings are equal; compareTo returns 0 exactly when the equals(Object) method would return true. 
//				
//		This is the definition of lexicographic ordering. If two strings are different, 
//		then either they have different characters at some index that is a valid index for both strings, 
//		or their lengths are different, or both. If they have different characters at one or more index positions, 
//		let k be the smallest such index; then the string whose character at position k has the smaller value, 
//		as determined by using the < operator, lexicographically precedes the other string. 
//		In this case, compareTo returns the difference of the two character values at position k in the two string 
//		-- that is, the value: 
//
//				 this.charAt(k)-anotherString.charAt(k)
		
		//Forma 1: Ordenando as empresas por nome, ordem crescente
		//empresas.sort((e1,e2)->{ return e1.getNome().compareTo(e2.getNome()); });		
		//empresas.sort((e1,e2) -> e1.getNome().compareTo(e2.getNome()));
		
		//Forma 2: Ordenando as empresas por nome, ordem decrescente.
		empresas.sort((e1, e2) -> e2.getNome().compareTo(e1.getNome()));
		
		//Forma 3: Ordenando as empresas por nome, ordem decrescente.
		//empresas.sort(Comparator.comparing(Empresa :: getNome, Comparator.reverseOrder()));
		
		//Anexa um atributo na requisição
		request.setAttribute("empresas", empresas);
		
		return "forward:listaEmpresas.jsp";
		
	}

}
