package java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class TesteMetodoForeach {

	public static void main(String[] args) {
		List<String> palavras = new ArrayList<>();
		palavras.add("alura online");
		palavras.add("casa do código");
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
		
		palavras.sort((str1, str2) -> str1.length() - str2.length());
		
//		System.out.println(palavras);
		
		palavras.forEach(palavra -> System.out.println(palavra));
		
		new Thread(() -> System.out.println("Executando um Runnable")).start();
		

	}
}

