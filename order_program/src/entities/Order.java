package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	private Date moment;
	private OrderStatus status;
	private Client client;
	private List<OrderItem> orderItems = new ArrayList<>();
	
	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	public void addItem(OrderItem item) {
		orderItems.add(item);
	}
	
	public void removeItem(OrderItem item) {
		orderItems.remove(item);
	}

	public Double total() {
		Double total = 0.0;
		
		for(OrderItem item : orderItems) {
			total += item.subTotal();
		}
		
		return total;
	}
	
	//faltou fazer string builder corretamente com orderItems, preguica :P
	@Override
	public String toString() {
		return "Order moment: " + moment + "\n" + "Order status: " + status + "\n" +
				"Order client:" + client.toString() + "\n" + "Order items:" + "\n" + 
				orderItems + "\n "+ "Total price: " + total();
	}
	
}
