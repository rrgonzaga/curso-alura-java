package br.com.alura;

import java.util.Collection;
import java.util.HashSet;

public class TestaPerformance {

	public static void main(String[] args) {
		
		//Collection<Integer> numeros = new ArrayList<>();
		Collection<Integer> numeros = new HashSet<>();
		
		long inicio = System.currentTimeMillis();
		
		for(int i = 1; i < 50000; i++) {
			numeros.add(i);
		}
		
		long fim = System.currentTimeMillis();
		
		long tempoExecucao = fim - inicio;
		
		System.out.println("Tempo de execução do for de inserção: " + tempoExecucao);
		
		
		inicio = System.currentTimeMillis();
		
		for(Integer numero : numeros) {
			numeros.contains(numero);
		}
		
		fim = System.currentTimeMillis();
		
		tempoExecucao = fim - inicio;
		
		System.out.println("Tempo de execução do for de pesquisa: " + tempoExecucao);
		
			

	}

}
