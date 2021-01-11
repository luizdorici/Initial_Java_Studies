package entities;

public class OrderItem {
	private Integer quantity;
	private Double price;
	private Product prod;
	
	public OrderItem(Integer quantity, Double price, String name) {
		this.quantity = quantity;
		this.price = price;
		this.prod = new Product(name, price);
	}
	
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Product getProd() {
		return prod;
	}

	public void setProd(Product prod) {
		this.prod = prod;
	}
	
	@Override
	public String toString() {
		return "OrderItem [quantity=" + quantity + ", price=" + price + ", prod=" + prod + "]";
	}

	public Double subTotal() {
		return price * quantity;
	}
	
}
