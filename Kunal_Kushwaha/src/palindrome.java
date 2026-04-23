
public class palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = null;
		System.out.println(isPalindrome(str));
		
		String str2 = "";
		System.out.println(isPalindrome(str2));
		
		String str3 = " ";
		System.out.println(isPalindrome(str3));
		
		String str1 = "NAman";
		System.out.println(isPalindrome(str1));
	}
	
	static boolean isPalindrome(String str) {
		if(str == null || str.length() == 0) return true;
		str = str.toLowerCase();
		for(int i = 0; i<= str.length()/2; i++) {
			char start = str.charAt(i);
			char end = str.charAt(str.length()-1-i);
			if(start!=end) {
				return false;
			}
		}
		return true;
	/*OR 2-pointer style
	 * 	int left = 0;	
		int right = str.length() - 1;

		while (left < right) {
    		if (str.charAt(left) != str.charAt(right))
        		return false;
    		left++;
    		right--;
		}
		return true;

	 */
	}

}
