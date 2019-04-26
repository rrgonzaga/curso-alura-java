package br.com.alura;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ExercicioHashMap {

	public static void main(String[] args) {
		Map<Integer, String> pessoas = new LinkedHashMap<>();
		
		pessoas.put(42, "Rodrigo Gonzaga");
		pessoas.put(21, "Leonardo Cordeiro");
        pessoas.put(27, "Fabio Pimentel");
        pessoas.put(19, "Silvio Mattos");
        pessoas.put(23, "Romulo Henrique");
        
              
        Set<Integer> idades = pessoas.keySet();
        
        List<Integer> idadesOrdenadas = new ArrayList<>(idades);
        
        idadesOrdenadas.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer idade1, Integer idade2) {
				return idade1 - idade2;
			}
			        	
        });
        
        idadesOrdenadas.forEach(idade -> {
        	System.out.format("%s tem %d anos.",pessoas.get(idade),idade);
        	System.out.println();
        });

	}

}
