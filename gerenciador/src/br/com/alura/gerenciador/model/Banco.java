package br.com.alura.gerenciador.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {
	
	private static List<Empresa> lista = new ArrayList<>();
	private static List<Usuario> usuarios = new ArrayList<>();
	
	private static Integer chaveSequencial = 1; 
	
	static {
		Empresa empresa = new Empresa();
		empresa.setId(Banco.chaveSequencial++);	
		empresa.setNome("Alura");
		Empresa empresa2 = new Empresa();
		empresa2.setId(Banco.chaveSequencial++);
		empresa2.setNome("Caelum");
		Banco.lista.add(empresa);
		Banco.lista.add(empresa2);
		
		Usuario usr01 = new Usuario("nico","12345");
		Usuario usr02 = new Usuario("ana","12345");
		
		Banco.usuarios.add(usr01);
		Banco.usuarios.add(usr02);
		
	}

	public void adiciona(Empresa empresa) {
		empresa.setId(Banco.chaveSequencial++);
		Banco.lista.add(empresa);		
	}
	
	public List<Empresa> getEmpresas() {
		return Banco.lista;
	}

	public void removeEmpresa(Integer id) {
		
		Iterator<Empresa> it = Banco.lista.iterator();
		
		while(it.hasNext()) {
			Empresa emp = it.next();
			if(id == emp.getId()) {
				it.remove();
			}
		}		
/**
 * OBS.: Não podemos fazer um laço e modificar a lista ao mesmo tempo, 
 * pelo menos não na implementação Arraylist. 
 * A forma tradicional de resolvermos esse problema foi introduzida no Java 1.5. 
 * Quando realizamos um laço, cada coleção (lista, set, hash) existente no projeto 
 * possui um objeto específico para fazer a iteração, chamado Iterator.
 *    		
 */
//		for (Empresa empresa : Banco.lista) {
//			if(id == empresa.getId()) {
//				Banco.lista.remove(empresa);
//			}
//		}	
		
	}

	public Empresa buscaEmpresaPorId(Integer id) {
		
		for(Empresa empresa : Banco.lista) {
			if(empresa.getId() == id) {
				return empresa;
			}			
		}
		
		return null;
	}

	public Usuario existeUsuario(String login, String senha) {		
		for(Usuario usuario: usuarios) {
			if(usuario.ehIgual(login, senha)) {
				return usuario;
			}
		}
		
		return null;
	}

}
