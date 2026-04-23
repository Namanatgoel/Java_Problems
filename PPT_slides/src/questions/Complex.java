package questions;

class complex{
	int re;
	int cm;

	complex(int a, int b){
		re = a;
		cm = b;
		display();
	}
	
	void display() {
		System.out.println(this.re+"+ i"+this.cm);
		System.out.println();
		System.out.println(re+"+ i"+cm);
		System.out.println();
		System.out.println();
	}
	
	complex add(complex c1, complex c2) {
		int ac;
		int bd;
		ac = c1.re + c2.re;
		bd = c1.cm + c2.cm;
		complex sum = new complex(ac, bd);
		return sum;
	}
}

public class Complex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		complex cl = new complex(32,67);
		complex cd = new complex(2,6);
		complex sum = cl.add(cl, cd);
		
		String s = "naman is a boy";
		char a[] = s.toCharArray();
		System.out.println(a);
		s.length();
		String words[] = s.trim().split("\\s+");
		System.out.println(words.toString());
	}

}
