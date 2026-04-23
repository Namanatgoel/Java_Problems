/*root = ((x + n/x)^0.5)/2
 * root is the actual square root
 * x is the assumed square root
 * we find our answer when error < 1
 * 
 * 
 * COMPLEXITY: O(log(n)F(n))
 * F(n) -> cost of calculating f(n)/f'(n) with n digit precision
 * */
public class newton_raphson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sqrt(36));
	}
	
	static double sqrt(double n) {
		double x = n;
		double root;
		while(true) {
			root = 0.5 * (x + (n/x));
			if(Math.abs(root - x)<0.001) {
				break;
			}
			x = root;
		}
		return root;
	}

}
