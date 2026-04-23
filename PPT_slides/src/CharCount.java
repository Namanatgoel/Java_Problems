
public class CharCount {
	public static void main(String[] args) {
		String str = "hello world";
		char ch = 'l';
		int count = 0;
		
		for(int i = 0; i<str.length(); i++) {
			if(str.charAt(i) == ch) {
				count++;
			}
		}
		System.out.println("Occurences of " + ch + ": " + count);
	}
}
