
public class noofdigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3457;
		int b = 10;
		int ans = (int)(Math.log(n) / Math.log(b)) + 1;
		System.out.println(ans);
		//complexity is log(n) as n no of times running
	}

}
