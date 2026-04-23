class Bbox{
		double width;
		double height;
		double depth;
	
		double volume() {
			return width*height*depth;
		}
		
		void setDim(double w, double h, double b) 
		{
			width = w;
			height = h;
			depth = b;
		}
}
public class boxes {
	public static void main(String[] args) {
		Bbox mybox1 = new Bbox();
		Bbox mybox2 = new Bbox();
		double vol;
		mybox1.setDim(10., 20, 15);
		mybox2.setDim(10.9, 20.9, 15.9);
		
		vol = mybox1.volume();
		System.out.println("Volume is "+vol);
		
		vol = mybox2.volume();
		System.out.println("Volume is "+vol);
	}
}
