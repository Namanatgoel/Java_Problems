
public class count_vowels {
	public static void main(String[] args) {
		String input = "Hello World";
		int vowelCount = countVowels(input);
		System.out.println("Number of vowels: " + vowelCount);
	}

	private static int countVowels(String input) {
		// TODO Auto-generated method stub
		int count = 0;
		String vowels = "aeiouAEIOU";
		for(int i = 0; i<input.length(); i++) {
			char ch = input.charAt(i);
			if(vowels.indexOf(ch) != -1) {
				count++;
			}
		}
		return count;
	}
}
