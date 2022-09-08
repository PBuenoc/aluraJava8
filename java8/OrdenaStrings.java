package java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class OrdenaStrings {

	public static void main(String[] args) {
		List<String> palavras = new ArrayList<>();
		
		palavras.add("caelum");
		palavras.add("Alura online");
		palavras.add("editora casa do codigo");
		
//		palavras.sort((s1, s2) -> {
//			if(s1.length() < s2.length())
//				return -1;
//			if(s1.length() > s2.length())
//				return 1;
//			return 0;
//		});
		
		//É o mesmo que o código acima
		
		//palavras.sort((s1, s2) -> Integer.compare(s1.length(), s1.length()));
		
		palavras.sort(Comparator.comparing(s -> s.length()));
		palavras.sort(Comparator.comparing(String::length));
		
		//Function<String, Integer> funcao = String::length;
		
		System.out.println(palavras);
		
//		for (String p : palavras) {
//			System.out.println(p);
//		}
	
//		Consumer<String> impressor = s -> System.out.println(s);
//		palavras.forEach(impressor);
		
		palavras.forEach(s -> System.out.println(s));
		
		//palavras.forEach(System.out::println);
		
		
		//new Thread(() -> System.out.println("Executando um Runnable")).start();
	}

}

