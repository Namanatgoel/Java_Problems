
public class powOf2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 32;
		//for n = 0 it gives true as well
		//EXCEPTION CASE
		boolean ans = (n & (n-1)) == 0;
		System.out.println(ans);
	}

}
