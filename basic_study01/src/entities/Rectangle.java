package entities;

public class Rectangle {
	double Width = 0.0;
	double Height = 0.0;
	
	public Rectangle(double a , double b) {
		this.Width = a;
		this.Height = b;
	}
	
	public double Area() {
		return Width * Height;
	}
	
	public double Perimeter() {
		return 2 * (Width + Height);
	}
	
	public double Diagonal() {
		return Math.sqrt(Math.pow(Width, 2.0) + Math.pow(Height, 2.0));
	}
}
