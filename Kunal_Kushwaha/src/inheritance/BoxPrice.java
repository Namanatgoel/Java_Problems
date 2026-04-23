package inheritance;

public class BoxPrice extends BoxWeight{
	double cost;
	BoxPrice(){
		super();
		this.cost = -1;
	}
	
	BoxPrice(BoxPrice other){
		super(other);
		this.cost = other.cost;
	}
	
	public BoxPrice(double l, double h, double b, double weight, double cost) {
		super(l,h,b,weight);
		this.cost = cost;
	 }
	
	
}
