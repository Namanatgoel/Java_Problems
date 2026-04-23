
public class str_array {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ros;
		ros = new int[5];
		System.out.println(ros[1]);
		
		String[] arr = new String[4];
		System.out.println(arr[0]);
	}
//diff between empty string and empty int array in java
//null can be compared to none in python
//null is  a special literal of null type, we can cast it to any particular reference type
	//but can't create a null type
	//ex -: null a = null; not possible
	//can't reference null to primitives
	String str = null; //string is non primitive type
/*	int num = null; //can't  assign the literal null to primitive
	any ref variable we have, by default, it is going to have the null type
	null is just a special value literal, not an object not a data type, which can be referenced
	to any reference type and you can type cast null to any type as well
	except can't do it for primitive data types
	it is the by default value of what reference variables point to*/
}
