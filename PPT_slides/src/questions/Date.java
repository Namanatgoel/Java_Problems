package questions;

class daate {
	int day;
	int month;
	int year;

	daate(int d, int m, int y) {
		day = d;
		month = m;
		year = y;
		display();
	}

	void display() {
		// TODO Auto-generated method stub
		System.out.println(this.day + "-" + this.month + "-" + this.year);
	}

	void add(int d) {
		this.day += d;
		display();
	}

	void duration(daate d1, daate d2) {
		daate dur;

		int dd;
		int dm;
		int dy;

		if (d1.day > d2.day)
			dd = d1.day - d2.day;
		else
			dd = d2.day - d1.day;

		if (d1.month > d2.month)
			dm = d1.month - d2.month;
		else
			dm = d2.month - d1.month;

		if (d1.year > d2.year)
			dy = d1.year - d2.year;
		else
			dy = d2.year - d1.year;
		
		dur = new daate(dd, dm, dy);
		System.out.println("The duration is: ");
		dur.display();
	}
}

public class Date {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		daate date1 = new daate(2,12,2006);
		date1.add(5);
		
		daate date2 = new daate(4,12,2006);
		
		date1.duration(date1, date2);
	}

}
