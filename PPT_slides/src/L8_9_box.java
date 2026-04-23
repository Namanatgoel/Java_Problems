class Test4 {
	int a;

	void SetVal(int i) {
		a = i;
	}

	Test4 incrByTen(int n) {
		Test4 temp = new Test4();
		temp.a = a + n; // ob1.a+n
		return temp;
	}
}

// class TestRetObect
public class L8_9_box {
	public static void main(String[] args) {
		Test4 ob1 = new Test4();
		Test4 ob2;
		ob1.SetVal(2);
		ob2 = ob1.incrByTen(10);// ob2.a: 12
		System.out.println("ob1.a: " + ob1.a);
		System.out.println("ob2.a: " + ob2.a);
	}
}