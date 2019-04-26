package br.com.alura.java.io.teste;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Locale;

public class TesteEscritaPrintStreamPrintWriter {
	
	public static void main(String[] args) throws IOException {
		//Fluxo de saída com Arquivo
		//OutputStream fos = new FileOutputStream("lorem2.txt");
		//Writer osw = new OutputStreamWriter(fos);
		//BufferedWriter bw = new BufferedWriter(osw);
		
		//FileWriter fw = new FileWriter("lorem2.txt");
		//BufferedWriter bw = new BufferedWriter(fw);
		
		PrintWriter pw = new PrintWriter("lorem2.txt","UTF-8"); 	
		
		long startTime = System.currentTimeMillis();
		
		double i = 0;
		while(i != 9999000.00) {
			i +=1;
		}
		
		pw.print("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod");
		pw.println();
		pw.print("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod");
		pw.println();
		pw.print("tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam");
		
			
		pw.close();	
		
		long endTime = System.currentTimeMillis();
		
		System.out.println("Temp o de execução em milissegundos: " + (endTime - startTime));
		//System.out.println(String.format("Formatando %07.3f", 45.3));
		System.out.format(Locale.US,"Formatando o valor double no formato americano: %07.3f", 45.3);
		//System.out.println(System.lineSeparator());
		System.out.println();
		System.out.format(new Locale("pt","BR"),"Formatando o valor double no formato brasileiro: %07.3f", 45.3);
		System.out.println();
		System.out.format(new Locale("pt","BR"),"Formatando o valor inteiro 20 com 2 zeros à esquerda: %04d", 20);
		System.out.println();
		String texto = "Welcome";
		System.out.format(new Locale("pt", "BR"), "Hello World! %s!", texto);

	}

}
