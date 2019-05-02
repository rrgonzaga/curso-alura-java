package java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestaCurso {

	public static void main(String[] args) {
		List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));
		
		//Ordenando cursos pela quantidade de alunos
		//Ordenando com uma expressão lambda
		cursos.sort(Comparator.comparingInt(c -> c.getAlunos()));
		//Ordenando com uma expressão method reference
		cursos.sort(Comparator.comparingInt(Curso::getAlunos));
		
		cursos.forEach(System.out::println);
		//cursos.forEach(c -> System.out.println(c.getNome()));
		
		System.out.println();
		
		//Filtrando apenas os cursos com mais de 50 alunos
		cursos.stream()
		.filter(curso -> curso.getAlunos() > 50)
		.map(Curso :: getNome) //.map(nome -> nome.getNome())
		.forEach(nomeCurso -> System.out.println(nomeCurso));
		
		System.out.println();
		
		//Filtrando apenas os cursos com mais de 50 alunos e 
		//criando um Stream<Integer> com a quantidade de alunos dos cursos com mais de 50 alunos e 
		//em seguida imprimindo as quantidades de alunos desses cursos
		cursos.stream()
		.filter(curso -> curso.getAlunos() > 50)
		.map(Curso :: getAlunos) //.map(qtdeAlunos -> qtdeAlunos.getAlunos())
		.forEach(System.out :: println); //.forEach(qtde -> System.out.println(qtde));
		
		
		
		
		
		
	}
}
