package java8;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class TestaDatas {
	public static void main(String[] args) {
		
		LocalDate today = LocalDate.now();
		System.out.format("Hoje é: %s", today);
		System.out.println();
		
		//Primeira opção: 
		//LocalDate futureDate = LocalDate.of(2099, 1, 25);
		//Segunda opção: 
		LocalDate futureDate = LocalDate.of(2099, Month.JANUARY, 25); 
		
		System.out.format("A data futura é: %s", futureDate);
		System.out.println();
		
		Period p1 = Period.between(futureDate, today);
		System.out.format("O perído é: %s", p1);
		System.out.println();
		
		Period p2 = Period.between(today, futureDate);
		System.out.format("O período entre as datas %s e %s  é: %s", today, futureDate, p2);
		System.out.println();
		System.out.format("Years: %d, Months: %d, Days: %d", p2.getYears(), p2.getMonths(), p2.getDays());
			
		//classe Duration para trabalhar com intervalo de horas
		System.out.println();
		Duration d1 = Duration.ofHours(20);
		System.out.println(d1);
		
		System.out.println();
		Duration d2 = Duration.ofMinutes(45);
		System.out.println(d2);
		
		System.out.println();
		Duration d3 = Duration.ofSeconds(59);
		System.out.println(d3);
		
		//Imprimindo a data de hoje no formato dd/MM/yyyy
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.format("Hoje é: %s", today.format(dateFormatter));
		System.out.println();
		
		//Imprimindo a data e hora de agora no formato dd/MM/yyyy HH:mm:ss		
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		System.out.format("Agora é: %s", now.format(dateTimeFormatter));		
	}	
}
