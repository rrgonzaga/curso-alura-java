package java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TesteMetodoForeach {

	public static void main(String[] args) {
		List<String> palavras = new ArrayList<>();
		palavras.add("alura online");
		palavras.add("casa do c�digo");
		palavras.add("caelum");
		
//		palavras.forEach(palavra -> {
//			System.out.println(palavra);
//		});	
		
//		Consumer<String> consumer = new ImprimePalavras();		
//		palavras.forEach(consumer);
		
//		palavras.sort(new Comparator<String>() {
//			@Override
//			public int compare(String str1, String str2) {
//				return str1.length() - str2.length();
//			}
//			
//		});	
		
		//palavras.sort((str1, str2) -> str1.length() - str2.length());
		//palavras.sort(Comparator.comparing(s -> s.length()));
		
		//Ordene comparando o m�todo length dentro de String
		//palavras.sort(Comparator.comparing(String::length));
		
		// mudando o crit�rio de compara��o para ordena��o. Em vez de tamanho, ordem alfab�tica
		palavras.sort(String.CASE_INSENSITIVE_ORDER);		
		
//		System.out.println(palavras);
		
		//palavras.forEach(palavra -> System.out.println(palavra));
		//Mudando o forEach para usar method reference no lugar de lambda
		palavras.forEach(System.out::println);
		
		//new Thread(() -> System.out.println("Executando um Runnable")).start();
		

	}
}

