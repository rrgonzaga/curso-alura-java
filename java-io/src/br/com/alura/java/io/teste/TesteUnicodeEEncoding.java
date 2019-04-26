package br.com.alura.java.io.teste;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class TesteUnicodeEEncoding {
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		String s = "Ç";
		System.out.println(s.codePointAt(0));
		
		Charset defaultCharset = Charset.defaultCharset();
		System.out.println(defaultCharset.name());
		
		byte[] bytes = s.getBytes("windows-1252");
		String sNovaString = new String(bytes,"windows-1252");
		System.out.format("Amount of bytes from string \"%s\" through from the enconding \"windows-1252\": %s. ", s, bytes.length);
		System.out.format("The same String enconded in \"windows-1252\": %s.", sNovaString);
		System.out.println();
		
		byte[] bytes2 = s.getBytes("UTF-16");
		sNovaString = new String(bytes2,"windows-1252");
		System.out.format("Amount of bytes from string \"%s\" through from the enconding \"UTF-16\": %s. ", s, bytes2.length);
		System.out.format("The same String enconded in \"windows-1252\": %s.", sNovaString);
		System.out.println();
		
		byte[] bytes3 = s.getBytes(StandardCharsets.US_ASCII);
		sNovaString = new String(bytes3,"windows-1252");
		System.out.format("Amount of bytes from string \"%s\" through from the enconding \"US_ASCII\": %s. ", s, bytes3.length);
		System.out.format("The same String enconded in \"windows-1252\": %s.", sNovaString);
		System.out.println();
		
		
		
		
		
	}
}
