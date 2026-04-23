import java.util.Scanner;
class EMPLOYEE{
	String Ename;
	int Eid;
	double Basic;
	double DA;
	double Gross_sal;
	double Net_sal;
	double IT;
	
	EMPLOYEE(){
		System.out.println("This is a default constructor");
		Ename = "Not provided";
		Eid = 0;
		Basic = 0.0;
		compute_net_salary(Basic);
		display();
	}
	
	EMPLOYEE(String name, int id, double basic){
		System.out.println("This is a parameterized constructor");
		Ename = name;
		Eid = id;
		Basic = basic;
		compute_net_salary(basic);
		display();
	}
	
	void compute_net_salary(double Basic) {
		DA = 0.52 * Basic;
		Gross_sal = Basic + DA;
		IT = 0.3 * Gross_sal;
		Net_sal = Gross_sal - IT;
	}
	
	void display() {
		System.out.println("The details are: ");
		System.out.println("NAME: "+Ename);
		System.out.println("ID: "+Eid);
		System.out.println("BASIC SALARY: "+Basic);
		System.out.println("DA: "+DA);
		System.out.println("GROSS SALARY: "+Gross_sal);
		System.out.println("IT: "+IT);
		System.out.println("NET SALARY: "+Net_sal);
		System.out.println();
	}
}
public class question2 {
	public static void main(String[] args) {
		EMPLOYEE emp1 = new EMPLOYEE();
		EMPLOYEE emp2 = new EMPLOYEE("Manujith", 98, 1000000);
	}

}
