package entities;

public class Employee {
	private int id;
	private String nome;
	private double salario;

	public Employee(int id, String nome, double salario) {
		super();
		this.id = id;
		this.nome = nome;
		this.salario = salario;
	}
	
	public void increaseSalary(double percentage) {
		salario += (salario * percentage) / 100;
	}
	
	public void printEmployee() {
		System.out.println(id + ", " + nome + ", " + salario);
	}

	public int getId() {
		return id;
	}
	
}
