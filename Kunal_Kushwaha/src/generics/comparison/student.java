package generics.comparison;

public class student implements Comparable{
	int rollno;
	float marks;
	
	public student(int rollno, float marks) {
		this.rollno = rollno;
		this.marks = marks;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
