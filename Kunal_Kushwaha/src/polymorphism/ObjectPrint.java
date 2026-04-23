package polymorphism;

public class ObjectPrint {
	int num;
	
	public ObjectPrint(int num) {
		this.num = num;
	}
	
	@Override //no error means it is overriding the original default toString() method
	public String toString() {
		return "ObjectPrint{"
				+"num="+num
				+'}';
	}
	/*
	 * At run time it determines, that this above method should be run
	 */
	
	/*
	 * cannot over ride a final declared method bec final declared methods can provide 
	 * a performance enhancement
	 */
	/*
	 * Late binding  is overriding , early binding is when final is there so cannot override
	 */
	
	public static void main(String[] args) {
		ObjectPrint obj = new ObjectPrint(54);
		System.out.println(obj);
		/*
		 * we haven't told java, that whenever we print this object, we want to print
		 * the number num, so internally it calls valueOf function then toString func
		 * it prints obj.toString, but
		 * our object which we passed dont have a toString method so it uses the default
		 * one, ie, the one inherited from the Object class
		 * 
		 */
	}
}
