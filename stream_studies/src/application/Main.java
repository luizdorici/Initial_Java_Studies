package application;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(3, 4, 5, 10, 7);
		
		//transforma uma lista de inteiros em uma stream
		Stream<Integer> st1 = list.stream();	
		//converte a stream para um vetor de strings e imprime
		System.out.println(Arrays.toString(st1.toArray()));
		
		//cria stream de nomes do tipo string
		Stream<String> st2 = Stream.of("Maria", "Alex", "Bob");
		//converte a stream para um vetor de strings e imprime
		System.out.println(Arrays.toString(st2.toArray()));
		
		//gera uma sequencia de numeros, no caso, 0, 0 + 2 = 2, 2 + 2 = 4, 4 + 2 = 6...
		Stream<Integer> st3 = Stream.iterate(0, x -> x + 2);
		//imprime os 10 primeiros elementos da sequencia
		System.out.println(Arrays.toString(st3.limit(10).toArray()));
		//interate eh apenas a regra para criacao da sequencia de stream
		
		//gera sequencia de fibonacci
		//p[1], p->new long[]{p[1], p[0]+p[1]} = (0, 1), (1, 1), (1, 2), (2, 3), (3, 5), (5, 8), (8, 13)...
		//map(p->p[0]) = 0, 1, 1, 2, 3, 5, 8...
		Stream<Long> st4 = Stream.iterate(new long[]{ 0L, 1L }, p->new long[]{ p[1], p[0]+p[1] }).map(p -> p[0]);
		//imprime os 10 primeiros numeros da sequencia
		System.out.println(Arrays.toString(st4.limit(10).toArray()));
		
	}

}
