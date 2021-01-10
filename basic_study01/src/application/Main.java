package application;

import java.util.Scanner;
import entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class Main {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("How many employees will be registered? ");
		int nroEmployees = sc.nextInt();
		List<Employee> employeesList = new ArrayList<>();
		
		for(int i = 0; i < nroEmployees; i++) {
			System.out.printf("Emplyoee #%d:%n", i+1);
			System.out.print("Id: ");
			int id = sc.nextInt();
			sc.nextLine();
			System.out.print("Name: ");
			String nome = sc.nextLine();
			System.out.print("Salary: ");
			double salario = sc.nextDouble();
			
			Employee employeeObj = new Employee(id, nome, salario); 
			
			employeesList.add(employeeObj);
			
		}
		
		System.out.print("Enter the employee id that will have salary increase : ");
		int id = sc.nextInt();
		
		Employee employeeObjTmp = employeesList.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		
		if( employeeObjTmp == null) {
			System.out.println("Id nao encontrado!!!");
		}else {
			System.out.print("Enter the percentage: ");
			double percentage = sc.nextDouble();
			employeeObjTmp.increaseSalary(percentage);
		}
		
		for(int i = 0; i < nroEmployees; i++) {
			Employee employeeObj = employeesList.get(i);
			employeeObj.printEmployee();
		}
		
		
		
		
		
		
		
		
		/*
					EXERCICIO 2
		Employee employee = null;
		
		System.out.printf("Type the employee's name: ");
		String Name = sc.nextLine();
		System.out.printf("Gross Salary: ");
		double grossSalary = sc.nextDouble();
		System.out.printf("Tax: ");
		double tax = sc.nextDouble();
		
		employee = new Employee(Name, grossSalary, tax);
		
		System.out.println("Employee: " + employee.Name + ", $ " + employee.netSalary());
		
		System.out.print("Which percentage to increase salary? ");
		double percentage = sc.nextDouble();
		
		employee.calculateNewSalary(percentage);
		System.out.println(employee.calculateNewSalary(percentage));
		---------------------------------------------------------------------------------------
		 			EXERCICIO 1
		System.out.printf("Digite a largura: ");
		double width = sc.nextDouble();
		System.out.printf("Digite a altura: ");
		double height = sc.nextDouble();
		
		Rectangle ret = new Rectangle(width, height);
		
		System.out.printf("Area = %.2f%n", ret.Area());
		System.out.printf("Perimetro = %.2f%n", ret.Perimeter());
		System.out.printf("Diagonal = %.2f%n", ret.Diagonal());
		*/
		
		sc.close();

	}

}
