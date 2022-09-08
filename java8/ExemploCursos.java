package java8;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class ExemploCursos {
	
	public static void main(String[] args) {
		List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));
		
		cursos.sort(Comparator.comparing(Curso::getAlunos));   //Compara os cursos em ordem crescente de acordo com a quantidade
		//cursos.forEach(c -> System.out.println(c));			//de alunos inscritos
	
		
		cursos.stream()
		.filter(c -> c.getAlunos() >= 100)
		.mapToInt(Curso::getAlunos)
		.forEach(System.out::println);
		
		int sum = cursos.stream() //Coloca em uma variavel sum a soma do stream filtrado 
				.filter(c -> c.getAlunos() >= 100) //filtra os cursos em cursos com mais de 100 alunos
				.mapToInt(Curso::getAlunos)  //Mapeia a lista e procura apenas a quantidade de alunos inscritos no curso.
				.sum();
		System.out.println("A soma dos curos com mais de 100 alunos é: " + sum);
		
		
		Stream<String> nomes = cursos.stream()
				.filter(c -> c.getAlunos() >= 46)
				.map(Curso::getNome);
		nomes.forEach(System.out::println);
		
		System.out.println("------------------//--------------------");
		
		cursos.stream()
				.filter(c -> c.getAlunos() >= 55)
				.findAny()
				.ifPresent(c -> System.out.println(c.getNome()));
		
//		cursos = cursos.stream().filter(c -> c.getAlunos() >= 100).collect(Collectors.toList());
//		cursos.forEach(System.out::println);
		
		System.out.println("------------------//--------------------");
		
		cursos.stream()
			.filter(c -> c.getAlunos() >= 100)
			.collect(Collectors.toMap(
					c -> c.getNome(),
					c -> c.getAlunos()))
			.forEach((nome, alunos) -> System.out.println("O curso " + nome + " tem " + alunos + " alunos."));
		
		
		OptionalDouble media = cursos.stream()
			.mapToDouble(Curso::getAlunos)
			.average();
		System.out.println("A media de alunos de todos os curos é : " + media);
		
	}
}

class Curso {
    private String nome;
    private int alunos;

    public Curso(String nome, int alunos) {
        this.nome = nome;
        this.alunos = alunos;
    }

    public String getNome() {
        return nome;
    }

    public int getAlunos() {
        return alunos;
    }
    
    @Override
    public String toString() {
    	return "Cursos: " + this.nome + ", Alunos: " + this.alunos;
    }
}
