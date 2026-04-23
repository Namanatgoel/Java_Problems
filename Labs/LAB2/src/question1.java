import java.util.Scanner;
public class question1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the charge(in Rs.): ");
		int charge = sc.nextInt();
		int dis = 0;
		if(charge<=50) {
			dis = charge/10;
		}
		else {
			dis = 5;
			charge = charge - 50;
			if(charge<=120) {
				dis = dis + (charge/8);
			}
			else {
				dis = dis + 15;
				charge = charge - 120;
				dis = dis + (charge/5);
			}
		}
		System.out.println("The distance travelled is: "+dis);
	}

}
