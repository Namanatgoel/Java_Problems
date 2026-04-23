import java.util.Random;
public class RandomString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 20;
		String name = RandomString.generate(n);
		System.out.println(name);
	}
	
	static String generate(int size) {
		java.lang.StringBuffer sb = new java.lang.StringBuffer(size);

//		StringBuffer sb = new StringBuffer(size);
		
		Random random = new Random();
		
		for(int i = 0; i<size; i++) {
			int randomChar = 97 + (int)(random.nextFloat()*26);
			sb.append((char)randomChar);
		}
		return sb.toString();
		
	}

}
