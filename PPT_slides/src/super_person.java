class Person {
	void message() {
		System.out.println("This is person class\n");
	}
}

// Subclass Student
class Studentka extends Person {
	void message() {
		System.out.println("This is student class");
	}

	void display() { // will invoke current class message()
		message();
// will invoke parent class message()
		super.message();
	}
}

// Driver Program
class super_person {
	public static void main(String args[]) {
		Studentka s = new Studentka();
// calling display() of Student
		s.display();
	}
}