class Student {
	int rollNo;
	int m1, m2;

	void getRollNum(int r) {
		rollNo = r;
	}

	void putRollNum() {
		System.out.println("Roll No: " + rollNo);
	}

	void getMarks(int a, int b) {
		m1 = a;
		m2 = b;
	}

	void putMarks() {
		System.out.println("Marks: " + m1 + ", " + m2);
	}
}

interface Sports {
	void putSportsScore(int s);
}

class Result extends Student implements Sports {
	int sportsScore;
	public void putSportsScore(int s) {
		sportsScore = s;
	}
	void display() {
		putRollNum();
		putMarks();
		System.out.println("The Sports Score: " + sportsScore);
		System.out.println("Overall Total: " + (m1 + m2 + sportsScore));
	}
}

public class ques3 {
	public static void main(String[] args) {
		Result res = new Result();
		res.getRollNum(19);
		res.getMarks(78, 34);
		res.putSportsScore(17);
		res.display();
	}
}