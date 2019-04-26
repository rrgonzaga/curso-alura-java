package br.com.alura;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ImprimindoAlunosSemAcentos {

	public static void main(String[] args) {
		Set<String> alunos = new HashSet<>();
		
		alunos.add("Paulo");
		alunos.add("Alberto");
		alunos.add("Pedro");
		alunos.add("Nico");			
		
		System.out.println(alunos.size());
		
		Boolean foiAdicionado = alunos.add("Alberto");
		
		System.out.println("Alberto foi adicionado novamente? " + foiAdicionado);
		
		System.out.println(alunos.size());
		
//		Antes do Java 5
//		Iterator<String> iterator = alunos.iterator();
//		
//		while(iterator.hasNext()) {
//			System.out.println(iterator.next());
//		}		
		
//		Antes do Java 8
//		for (String aluno : alunos) {
//			System.out.println(aluno);
//		}
		
//		A partir do Java 8
		alunos.forEach(aluno -> {
			System.out.println(aluno);
		});
	}

}
