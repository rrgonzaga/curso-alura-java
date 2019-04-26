package br.com.alura;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class TesteTreeSet {

	public static void main(String[] args) {
		
		Funcionario f1 = new Funcionario("Barney", 12);
        Funcionario f2 = new Funcionario("Jonatan", 9);
        Funcionario f3 = new Funcionario("Guaraciara", 13);
        Funcionario f4 = new Funcionario("Rodrigo Gonzaga", 42);
        Funcionario f5 = new Funcionario("Bruno Costa", 30);
        
        
        
        //A implementação TreeSet já ordena os seus elementos na hora da inserção. 
        //Qual é o critério da ordenação depende e pode ser definido através de um Comparator.
        Set<Funcionario> funcionarios = new TreeSet<>(new OrdenaPorIdade());
        
        funcionarios.add(f1);
        funcionarios.add(f2);
        funcionarios.add(f3);
        funcionarios.add(f4);
        funcionarios.add(f5);
        
        Iterator<Funcionario>iterator = funcionarios.iterator();
        
        while(iterator.hasNext()) {
        	System.out.println(iterator.next());
        }
        
        

	}

}
