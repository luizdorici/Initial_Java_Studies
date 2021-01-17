package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Employee;

public class Main {

	public static void main(String[] args) {
		
		String path = "C:\\Users\\Luiz\\Desktop\\eclipse-workspace\\stream_practice\\src\\in.txt";
		List<Employee> employees = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter salary: ");
		Double baseSalary = sc.nextDouble();
		
		//try para tratar excecoes na hora de ler o arquivo
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			//leitura linha a linha do arquivo
			String line = br.readLine();
			while(line != null) {
				
				//split para separar numero de votos do nome do candidato (key)
				String[] fields = line.split(",");
				
				Double salary = Double.parseDouble(fields[2]);
				
				//cria e adiciona campos de cada funcionario
				Employee employee = new Employee(fields[0], fields[1], salary);
				employees.add(employee);
				
				line = br.readLine();
			}
			
		} catch (IOException e) {
			//msg em caso de excecao (file == null)
			System.out.println("Error: " + e.getMessage());
		}

		//imprime todos os funcionarios da lista
		employees.forEach(System.out::println);
		
		//cria comparator para comparar duas strings
		Comparator<String> comp = (s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase());
		
		//filtra salarios maiores que baseSalary
		//ordena a nova stream com emails de quem possui salario maiores que baseSalary
		//converte stram para lista
		List<String> emails = employees.stream().filter(p -> p.getSalary() > baseSalary) 
				.map(p -> p.getEmail()).sorted(comp)
				.collect(Collectors.toList());
		
		System.out.println();

		//filtra lista de funcionarios para pegar apenas funcionarios com nome que comecam com letra M
		//utiliza map para pegar cada campo salario na stream gerada 
		//utiliza reduce para fazer a soma dos salarios de cada funcionario da stream gerada
		Double sum = employees.stream().filter(p -> p.getName().charAt(0) == 'M')
				.map(p -> p.getSalary())
				.reduce(0.0, (x,y) -> x + y);
		
		System.out.println("Sum of salary of people whose name starts with 'M': " + sum);
		
		System.out.println();
		
		emails.forEach(System.out::println);
		
		
		sc.close();
	}

}
