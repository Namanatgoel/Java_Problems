package questions;

class PolyDemo extends Exception {
	public PolyDemo(String msg) {
		super(msg);
	}


//public class PolyDemo {
//    public static void checkNumber(int num) throws NegativeNumberException {

//    }

	public static void main(String[] args) {
		try {
			if (-5 < 0) {
				throw new PolyDemo("Number cannot be negative!");
			}
			System.out.println("Number is valid: " + -5);
			// checkNumber(-5);
		} catch (PolyDemo e) {
			System.out.println("Caught Custom Exception: " + e.getMessage());
		}
	}
}