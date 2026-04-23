import java.util.Scanner;
public class do_while {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		char ch;
		do {
		System.out.print("Press a key followed by ENTER");
		ch = (char)System.in.read();
		System.out.println(ch);
		} while(ch != 'x');
	}

}
