package enumsExamples;

public class Basic {
	enum Week implements A{
		Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday
		//these are enum constants 
		//every single one over here is=> public, static and final member
		// since it is final, we can't create child enums
		//the type of all of these members is Week
;

		@Override
		public void hello() {
			// TODO Auto-generated method stub
			System.out.println("Hey hwo are u");
		}
		
//		Week() {
//			System.out.println("Constructor called for "+this);
//		}
		/*
		 * the constructor will run for all the members, despite us only defining
		 * Monday in the main
		 * 
		 * The constructor here is not public or protected, 
		 * it can be only private or default
		 * BECAUSE public or protected will allow initialization of more than 1 objects
		 * we dont want to create new objects bec this is not the enum concept
		 * 
		 * Internally: public static final Week Monday = new Week();
		 */
	}
	
	public static void main(String[] args) {
		Week week;
		week = Week.Monday;
		
		for(Week day:Week.values()) {
			System.out.println(day);
		}
		
		System.out.println(week);
		System.out.println(week.ordinal());
		//ordinal is position of the enum declaration
		
		week.hello();
		System.out.println(Week.valueOf("Monday"));
	}
}
