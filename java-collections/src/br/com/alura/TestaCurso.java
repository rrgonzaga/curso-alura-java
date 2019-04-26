package br.com.alura;

import java.util.List;

public class TestaCurso {

	public static void main(String[] args) {
		
		Curso javaColecoes  = new Curso("Dominando as coleções do Java", "Paulo Silveira");
		
		javaColecoes.adiciona(new Aula("Trabalhando com ArrayList", 21));
		javaColecoes.adiciona(new Aula("Revistando as ArrayLists", 19));
		javaColecoes.adiciona(new Aula("Listas de objetos", 20));
		javaColecoes.adiciona(new Aula("Relacionamento de listas e objetos", 15));
		
		List<Aula> aulas = javaColecoes.getAulas();
		System.out.println(aulas);
	}

}
