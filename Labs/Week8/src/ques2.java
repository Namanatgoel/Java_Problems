interface Series {
	int getNext();

	void reset();

	void setStart(int x);
}

class ByTwos implements Series {
	int s;
	int v;

	public int getNext() {
		v += 2;
		return v;
	}

	public void reset() {
		v = s;
	}

	public void setStart(int x) {
		s = x;
		v = x;
	}
}

public class ques2 {
	public static void main(String[] args) {
		Series sr = new ByTwos();
		sr.setStart(1);
		System.out.println("Series:");
		for (int i = 0; i < 5; i++) {
			System.out.println(sr.getNext());
		}
		sr.reset();
		System.out.println("Number after reset:");
		System.out.println(sr.getNext());
	}
}