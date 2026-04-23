import java.util.Scanner;
import java.util.Random;
class Die{
	int sideUp;
	public static int dice_number = 0;
	Random rd = new Random();
	int getSideUp() {
		return sideUp;
	}
	
	void roll() {

		sideUp = rd.nextInt(6)+1;
		//sideUp = (int) ((Math.random()*6) + 1);
		dice_number++;
		System.out.println("SIDEUP of dice "+dice_number+": "+sideUp);
	}
}

class DieDemo{
	int make_objects(){
		Die die1 = new Die();
		Die die2 = new Die();
		die1.roll();
		die2.roll();
		int sum = die1.getSideUp()+die2.getSideUp();
		return sum;
	}
}
public class ques4 {
	public static void main(String[] args) {
		DieDemo d1 = new DieDemo();
		System.out.println(d1.make_objects());
	}

}