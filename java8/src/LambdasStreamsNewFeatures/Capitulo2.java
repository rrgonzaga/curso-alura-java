package LambdasStreamsNewFeatures;

import java.util.Arrays;
import java.util.List;

public class Capitulo2 {
	public static void main(String[] args) {
		Usuario user1 = new Usuario("Rodrigo Gonzaga",150);
		Usuario user2 = new Usuario("Juliana Gonzaga",140);
		Usuario user3 = new Usuario("Enzo Gonzaga",145);
		
		//Maneira de iterar objetos de uma coleção antes do Java 8
		List<Usuario> usuarios = Arrays.asList(user1,user2,user3);
		for(Usuario u : usuarios) {
			System.out.println(u.getNome());
		}
		
		//Maneira de iterar objetos de uma coleção com forEach no Java 8
		usuarios.forEach(u -> System.out.println(u.getNome()));
		
	}

}
