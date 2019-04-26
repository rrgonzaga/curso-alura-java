package br.com.alura;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Curso {
	
	private String nome;
	private String instrutor;
	private List<Aula> aulas = new LinkedList<Aula>();
	private Set<Aluno> alunos = new HashSet<>();
	private Boolean isCancelled = false;
	
	Map<Integer, Aluno> matriculaParaAluno = new HashMap<>();
	
	public Curso(String nome, String instrutor) {
		this.nome = nome;
		this.instrutor = instrutor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getInstrutor() {
		return instrutor;
	}

	public void setInstrutor(String instrutor) {
		this.instrutor = instrutor;
	}

	public List<Aula> getAulas() {
		return Collections.unmodifiableList(aulas);
	}

	public void setAulas(List<Aula> aulas) {
		this.aulas = aulas;
	}
	
	public void adiciona(Aula aula) {
		aulas.add(aula);
	}
	
	public int getTempoTotal() {
		
//		int tempoTotal = 0;
//		
//		for (Aula aula : aulas) {
//			tempoTotal += aula.getTempo();			
//		}
		
		return aulas.stream().mapToInt(Aula :: getTempo).sum();		
		
//		return tempoTotal;
	}
	
	public void matricula(Aluno aluno) {
		alunos.add(aluno);
		matriculaParaAluno.put(aluno.getNumeroMatricula(), aluno);	
	}
	
	public Set<Aluno> getAlunos() {
		if (!isCancelled)
			return Collections.unmodifiableSet(alunos);
		
		return Collections.emptySet();
		
	}
	
	public void cancela() {
		isCancelled = true;		
	}
	
	public Boolean estaMatriculado(Aluno aluno) {
		return alunos.contains(aluno);
	}
	
	public Aluno buscaMatriculado(int matricula) {
		return matriculaParaAluno.get(matricula);
	}
	
	@Override
	public String toString() {
		return String.format("[Curso: \"%s\", tempo total: %d, %naulas: " + this.getAulas() + "]", getNome(), getTempoTotal());
	}
}
