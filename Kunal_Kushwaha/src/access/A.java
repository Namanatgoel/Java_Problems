package access;

public class A {
	/*
	 * private means only in this class
	 * 
	 * public - everywhere can access
	 * 
	 * default - when dont specify any access modifier, then it allows access in the
	 * same package but not in different package
	 */
	protected int num;
	String name;
	int[] arr;
	
	public int getNum() {
		return num;
	}
	
	public void setNum(int num) {
		this.num = num;
	}
	
	public A(int num, String name) {
		this.num = num;
		this.name = name;
		this.arr = new int[num];
	}
	
}
