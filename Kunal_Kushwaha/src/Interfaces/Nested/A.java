package Interfaces.Nested;

public class A {
	//nested interface
	public interface NestedInterFace{
		boolean isOdd(int num);
	}
}

class B implements A.NestedInterFace{

	@Override
	public boolean isOdd(int num) {
		// TODO Auto-generated method stub
		return (num & 1)==1;
	}
}
/*
 * the nested interface can only be declared public, private or protected
 * but top-level interface has to be declared public or the default one 
 */



