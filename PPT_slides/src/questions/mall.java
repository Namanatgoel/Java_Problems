package questions;
public class mall {
	
	static String mallname = "DLF";
	String city;
	
	static void display() {
		System.out.println(mallname);
	}
	
	mall(){
		mallname = "def";
		city = "Delhi";
	}
	
	mall(String mlname, String cty){
		this.mallname = mlname;
		this.city = cty;
	}
	
	class shop{
		String shopname;
		int shopno;
		int floor;
		
		shop(){
			shopname = null;
			shopno = 43;
			floor = 4;
		}
		
		shop(String shopname, int shopno, int floor){
			this.shopname = shopname;
			this.shopno = shopno;
			this.floor = floor;
		}
		
		void display() {
			System.out.println("THE SHOPNAME IS: "+shopname);
			System.out.println("THE SHOPNAMEIS: "+this.shopname);
			
			System.out.println("THE SHOPNO IS: "+shopno);
			System.out.println("THE SHOPNOIS: "+this.shopno);
			
			System.out.println("THE FLOOR IS: "+floor);
			System.out.println("THE FLOORIS: "+this.floor);
		}
	}
	
	public static void main(String[] args) {
		System.out.println();
		
	}

}
