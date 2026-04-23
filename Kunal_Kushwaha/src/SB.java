/*TAKE THEORY REFERENCE FROM Performance.java file*/
public class SB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i<26; i++) {
			char ch = (char)('a'+i);
			builder.append(ch);
		}
		System.out.println(builder); //automatic calling toString class
		//OR
		System.out.println(builder.toString()); //can convert to string if done with all
		//calculations and everything
		
		builder.deleteCharAt(0);
		System.out.println(builder); 
		
		builder.reverse();
		System.out.println(builder); 
	}
/*StringBuilder is mutable just like arrays*/
}
