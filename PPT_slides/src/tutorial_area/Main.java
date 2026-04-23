package tutorial_area;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Triangle t = new Triangle();
		Rectangle tt = new Rectangle();
		Area a; //reference variable of the interface, cannot create its object
		//interface can then be assigned objects
		a=t;
		System.out.println(a.findArea(10, 20));
		a=tt;
		System.out.println(a.findArea(1, 20));
	}

}
