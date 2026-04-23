
public class changing_char {

	public static void main(String[] args) {
		String str = "hello";
		System.out.println(str); // Output: hello
		char[] charArray = str.toCharArray();
		// Modify character (e.g., change 'h' to 'H')
		charArray[0] = 'H';
		// Convert back to string
		String newStr = new String(charArray);
		System.out.println(newStr); // Output: Hello
	}
}
