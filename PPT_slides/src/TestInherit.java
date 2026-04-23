class OneDimPoint {
	int x = 3;

	int getX() {
		return x;
	}
}

class TwoDimPoint extends OneDimPoint {

	int y = 4;

	int getY() {
		return y;
	}
}

public class TestInherit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TwoDimPoint pt = new TwoDimPoint();
		/*creating object of only subclass
		 * but can call superclass method
		 * bec subclass has all the features of the superclass
		 */
		System.out.println(pt.getX() + "," + pt.getY());
	}

}
