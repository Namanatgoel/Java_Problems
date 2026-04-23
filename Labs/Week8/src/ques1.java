abstract class Figure {
	int x;
	int y;

	Figure(int x, int y) {
		this.x = x;
		this.y = y;
	}

	abstract void area();
}

class Rectangle extends Figure {
	void area() {
		System.out.println("Rectangle Area is: " + (x * y));
	}
	
	Rectangle(int x, int y) {
		super(x, y);
	}
}

class Triangle extends Figure {
	Triangle(int x, int y) {
		super(x, y);
	}

	void area() {
		System.out.println("Triangle Area is: " + (0.5 * x * y));
	}
}

class Square extends Figure {
	Square(int x) {
		super(x, x);
	}

	void area() {
		System.out.println("Square Area is: " + (x * x));
	}
}

public class ques1 {
	public static void main(String[] args) {
		Figure fig;
		fig = new Rectangle(6, 5);
		fig.area();
		fig = new Triangle(4, 3);
		fig.area();
		fig = new Square(8);
		fig.area();
	}
}