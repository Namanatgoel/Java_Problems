package exceptionhandling;

public class Main {
	public static void main(String[] args) {
		int a = 5;
		int b = 0;
		try {
//			divide(a,b);
			//mimicking an exception
			//throw new Exception("just for fun");
			String name = "Kunal";
			if(name.equals("Kunal")) {
				throw new myException("name is kunal");
			}
		} catch(myException e) {
			System.out.println(e.getMessage());
		} catch(ArithmeticException e) {
			System.out.println(e.getMessage());
		} catch(Exception e) {
			System.out.println("normal exception caught");
		} 
		
		/*
		 * above if we change the order to this:
		 * catch(Exception e){}
		 * catch(ArithmeticException e){}
		 * then it will give an error that the exception was already caught
		 * why are we catching it again bec first Exception waala catch is there
		 * and it includes everything
		 * so more strict exceptions have to be added first
		 */
		finally {
			System.out.println("Finally means no matter what happens but"
					+ " this will always execute");
		}
		/*
		 * can use finally keyword only once, not multiple times
		 */
		
}
	static int divide(int a, int b) throws ArithmeticException{
		
		if(b==0) {
			throw new ArithmeticException("aare baba, 0 se mat kr divide");
		}
		
		return a/b;
		/*
		 * throw and throws are different 
		 * throw means we are throwing an exception
		 * throws is just used to declare exceptions, so here throws say that
		 * if u r using divide function, it may throw an exception
		 */
	}
}
