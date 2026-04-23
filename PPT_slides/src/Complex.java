
class Coomplex {
	double re, im;

	public Coomplex(double re, double im) {
		this.re = re;
		this.im = im;
	}

	public Coomplex(Coomplex c) {
		System.out.println("Copy constructor called");
		re = c.re;
		im = c.im;
	}

	public void display() {
		System.out.println(re + " + " + im + "i");
	}
}

public class Complex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Coomplex c1 = new Coomplex(10, 15);
		// Following involves a copy constructor call
		Coomplex c2 = new Coomplex(c1);
		c2.display(); // same value as c1
		Coomplex c3 = c2;// Does not invoke copy constructor
		c3.re = 100;
		c3.display();
		c2.display();
		c1.display();
	}

}
