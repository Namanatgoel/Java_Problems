class Student_this{	
	int rno;
	double marks;
	String name;
	
	Student_this(){
		//this is how you call a constructor from another constructor
		this (39, "default person", 100.0f);
		//internally: new Student (39, "default person", 100.0f);
	}
	
	Student_this(int rno, String name, float marks){
		this.rno = rno; 					//internally kunal.rno = 32;
		this.name = name;	//internally kunal.rno = Kunal Kushwaha;
		this.marks = marks;				//internally kunal.marks = 43.4;
		
	}
	

	Student_this (Student_this other){
		/*this will be replaced by random and other will be replaced by the parameter
		 * passed inside that, here kunal is passed so other will be replaced by kunal
		 */
		this.name = other.name;
		this.rno = other.rno;
		this.marks = other.marks;
		/*
		 * other.name = this.name;
		 * other.rno = this.rno;
		 * other.marks = this.marks;
		 * 
		 * OUTPUT of above 3 statements:
		 * 	null
		 * 	0
		 * 	0.0*/
	}

	
	void greeting() {
		System.out.println("Hello my name is: "+name);
	}
	//this keyword is used to access the reference variable
	
	void better_greeting() {
		System.out.println("Hello my new name is: "+ this.name);
	}
}
public class this_keyword {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student_this kunal = new Student_this();
		Student_this rahul = new Student_this(43, "rahul da", 90.0f);
		
		kunal.greeting();
		rahul.greeting(); //prints kunal kushwaha only if this keyword not used there
	
		kunal.better_greeting();
		rahul.better_greeting();
		//	System.out.println(kunal.greeting());
		
		System.out.println(kunal.rno);
		System.out.println(kunal.marks);
		System.out.println(kunal.name);
		
		System.out.println(rahul.rno);
		System.out.println(rahul.marks);
		System.out.println(rahul.name);
		
		Student_this random = new Student_this(kunal);
		System.out.println("\n this is testing the new other thing");
		System.out.println(random.name);
		System.out.println(random.rno);
		System.out.println(random.marks);
		
		System.out.println("\n this is testing calling one constructor form another");
		Student_this random2 = new Student_this();
		
		Student_this one = new Student_this();
		Student_this two = one;
		
		one.name = "Something Something";
		System.out.println("The name for two is also changed to: "+two.name);
	}

}
