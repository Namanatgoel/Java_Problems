package Interfaces;

public class NiceCar {
	private engine engine;

	private media player = new CD_player();
	
	public NiceCar() {
		engine = new PowerEngine();
	}

	public NiceCar(engine engine) {
		this.engine = engine;
	}
	
	public void start() {
		engine.start();
		/*
		 * now, if the engine is initialized, it goes to the respective type engine
		 */
	}
	
	public void stop() {
		engine.stop();
	}
	
	public void startMusic() {
		player.start();
	}
	/*
	 * now it starts and stops music whenever we say it, instead of the engine
	 */
	public void stopMusic() {
		player.stop();
	}
	
	public void upgradeEngine() {
		this.engine = new ElectricEngine();
	}
}