package br.com.alura;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestaCurso2 {

	public static void main(String[] args) {
		
		Curso javaColecoes  = new Curso("Dominando as coleções do Java", "Paulo Silveira");
		
		javaColecoes.adiciona(new Aula("Trabalhando com ArrayList", 21));
		javaColecoes.adiciona(new Aula("Revistando as ArrayLists", 19));
		javaColecoes.adiciona(new Aula("Listas de objetos", 20));
		javaColecoes.adiciona(new Aula("Relacionamento de listas e objetos", 15));
		
		List<Aula> aulasImutaveis = javaColecoes.getAulas();
		
		List<Aula> aulas = new ArrayList<>(aulasImutaveis);
		
		Collections.sort(aulas);
		
		//System.out.println(aulas);
		
		System.out.format("Carga horária do curso \"%s\" é: %d.", javaColecoes.getNome(), javaColecoes.getTempoTotal());
		System.out.println();		
		System.out.println(javaColecoes);
		
		
	}

}
