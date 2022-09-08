package java8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;


public class Datas {

	public static void main(String[] args) {
		LocalDate hoje = LocalDate.now();
		System.out.println(hoje);
		
		LocalDate olimpiadas2024 = LocalDate.of(2024, 7, 26);
		
		Period periodo = Period.between(hoje, olimpiadas2024);
		
		LocalDate proximasOlimpiadas = olimpiadas2024.plusYears(4);
		System.out.println(proximasOlimpiadas);
		
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		String valorFormatado = proximasOlimpiadas.format(formatador);
		System.out.println(valorFormatado);
		
		DateTimeFormatter formatadorComHoras = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
		LocalDateTime agora = LocalDateTime.now();
		System.out.println(agora.format(formatadorComHoras));
	}

}
