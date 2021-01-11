package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.enums.OrderStatus;

public class Main {

	//throws exception sera tratado em estudos futuros
	public static void main(String[] args) throws ParseException {
		//criando o scanner para fazer input do terminal
		Scanner sc = new Scanner(System.in);
		//criando uma variavel do formato simple date com a mascara dd/MM/yyyy
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		
		//coletando os dados do cliente
		System.out.println("Enter cliente data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		
		//pega o campo data como string e converte para o formato Date
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date date = sdf1.parse(sc.nextLine());
		
		//cria o objeto do cliente
		Client client = new Client(name, email, date);
		
		//coletando dados do pedido
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		String status = sc.nextLine();
		
		//cria pedido
		Date newdate = new Date();
		Order order = new Order(newdate, OrderStatus.valueOf(status), client);
		System.out.print("How many items to this order? ");
		int nroItems = sc.nextInt();
		sc.nextLine();
		
		//coletando produtos a serem adicionados no pedido
		for(int i = 0; i < nroItems; i++) {
			System.out.print("Product name: ");
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			Double productPrice = sc.nextDouble();
			sc.nextLine();
			System.out.print("Quantity: ");
			Integer productQuantity = sc.nextInt();
			sc.nextLine();
			
			//criar item de pedido e adicionar ao pedido
			OrderItem item = new OrderItem(productQuantity, productPrice, productName);
			order.addItem(item);
		}
		System.out.println("ORDER SUMMARY:");
		System.out.println(order.toString());

	}

}
