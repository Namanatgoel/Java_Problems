import java.util.Scanner;
public class question6 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int total =0;
		int bill=0;
		int finalprice = 0;
		
		for(int i = 0; i<7; i++) 
		{
		System.out.print("Enter the daily consumption for day "+(i+1)+ ": ");
		bill = sc.nextInt();
		total+=bill;
		}
		
		System.out.println("Your total consumption is: "+total);
		
		int flag = 0;
		if(total<=100) {
			flag = 0;
		}
		else if(total<=200) {
			flag = 1;
		}
		else flag = 2;
		
		switch(flag) {
		case 0:
			finalprice = 7*total;
			break;
		case 1:
			finalprice = 7*100 + (total-100)*8;
			break;
		case 2:
			finalprice = 7*100 + 100*8 + (total-200)*10;
			break;
		}
		
		System.out.print("The total bill amount is: "+finalprice);
		sc.close();
	}

}
