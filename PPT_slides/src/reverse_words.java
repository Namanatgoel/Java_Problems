import java.util.Scanner;
public class reverse_words {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a String: ");
		String input = scanner.nextLine();
		scanner.close();
		
		String[] words = input.split(" ");
		String reversedString = "";
		
		for(String word: words) {
			char[] charArray = word.toCharArray();
			String reversedWord = "";
			for(int i = charArray.length-1; i>=0; i--) {
				reversedWord += charArray[i];
			}
			reversedString += reversedWord + " ";
		}
		System.out.println(reversedString.trim());
	}
}