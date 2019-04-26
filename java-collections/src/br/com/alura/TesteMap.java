package br.com.alura;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TesteMap {

	public static void main(String[] args) {
		
		Map<String, Integer> nomesParaIdade = new HashMap<>();
		
        nomesParaIdade.put("Paulo", 31);
        nomesParaIdade.put("Adriano", 25);
        nomesParaIdade.put("Alberto", 33);
        nomesParaIdade.put("Guilherme", 26);
        nomesParaIdade.put("Rodrigo", 42);
        
        nomesParaIdade.forEach((nome, idade) -> {
        	System.out.format("%s tem %d anos.", nome, idade);
        	System.out.println();
        });
        
        System.out.println();
        System.out.println("Mostrando associações do HashMap através do método entrySet.");
        
        Set<Entry<String, Integer>> associacoes = nomesParaIdade.entrySet();
        
        for (Entry<String, Integer> associacao : associacoes) {
        	System.out.format("%s tem %d anos.", associacao.getKey(), associacao.getValue());
        	System.out.println();
		}
        
        System.out.println();
        System.out.println("Mostrando apenas os nomes (keys)");
        Set<String> nomes = nomesParaIdade.keySet();
        nomes.forEach(nome -> {
        	System.out.println(nome);
        });
        
        System.out.println();
        System.out.println("Mostrando apenas as idades (values)");
        Collection<Integer> idades = nomesParaIdade.values();
        
        for (Integer idade : idades) {
        	System.out.println(idade);
		} 

	}

}
