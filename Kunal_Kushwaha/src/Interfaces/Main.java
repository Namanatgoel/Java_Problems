package Interfaces;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car car = new Car();
		/*
		 * we can add the type of the variable as the type of the interface
		 * but then like can't access the variable a from the Car class
		 */
///		car.a;
		engine car2 = new Car();
		
		car.acc();
		car.start();
		car.brake();
		
		car2.acc();
		car2.start();
	//	car2.brake();
		
		media carMedia = new Car();
		System.out.println("CHecking media here");
		carMedia.stop();
		//it stops the engine
		/*
		 * that is why we create separate classes for these interfaces as well
		 */
		
		NiceCar car4 = new NiceCar();
		car4.start();
		//be default the power engine start
		car4.startMusic();
		//music starts
		car4.upgradeEngine();
		car4.start();
		/*
		 * without creating a new object, we changed the part of the engine
		 */
	}

}
