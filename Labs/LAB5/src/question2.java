/*2.     Employee Class 
Implement an EMPLOYEE class with an inner class named Department that handles 
department-related details. The inner class Department should: 
a. Contain fields for departmentName and location. 
b. Provide methods to set and display department details. 
The EMPLOYEE class should: 
Contain fields for eName (employee name), salary, and an array of Department objects. 
Provide methods to: 
c) Add departments. 
d) Display employee details along with department information. */
class EMPLOYEE{
	class Department{
		String departmentName;
		String location;
		void set() {
			System.out.println("Department name: ");
			
			System.out.println("Location: ");
		}
	}
}
public class question2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
