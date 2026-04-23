
public class Performance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String series = "";
		for(int i = 0; i<26; i++) {
			char ch = (char)('a'+i);
			series += ch;
		}
		System.out.println(series);
		/*as string as immutable so new string object being created every time
		 * if we keep adding to the string, and that object is copying the old one and then
		 * appending the new changes.
		 * All the old objects are dereferenced 
		 * ex-: ""+"a" -> "a"
		 * "a"+"b" -> "ab"
		 * "ab"+"c" -> "abc"
		 * So much memory wastage, so in the end,
		 * a,ab,abc,....,abcd..y all of this strings will have no reference variable
		 * O(N^2) as 1+2+....+N = N(N+1)/2
		 * so we have O(N^2) time complexity for adding N characters in a string
		 * SOLUTION?
		 * A datatype which allows us to modify its value, so that everytime we are adding
		 * a string to the series object, it is making changes to the same object only, and
		 * not making new ones, like arrays in which adding N items takes N operations.
		 * 
		 * STRINGBUILDER is such a data type, where only one object is made and the changes
		 * are done in that object only, the reference is also the same and is not changed.
		 * It is a separate class just like String
		 */
	}

}
