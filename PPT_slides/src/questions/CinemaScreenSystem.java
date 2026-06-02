package questions;

class SeatsNotAvailableException extends Exception{
	public SeatsNotAvailableException(String msg) {
		super(msg);
	}
}

interface Bookable{
	void bookTickets(String customerName, int numberofSeats) throws SeatsNotAvailableException;
}

class CinemaScreen implements Bookable{
	int screenNumber, totalSeats, availableSeats;
	String movieName;
	
	CinemaScreen(int num, String movie, int total){
		this.screenNumber = num;
		this.movieName = movie;
		this.totalSeats = total;
		this.availableSeats = total;
	}
	
	@Override
	public void bookTickets(String customerName, int seats) throws SeatsNotAvailableException {
		// TODO Auto-generated method stub
		if(seats>availableSeats) {
			throw new SeatsNotAvailableException("Failure: "+seats+" seats requested, only "+ availableSeats + " available.");
		}
		availableSeats -= seats;
		System.out.println("Success: " + seats + " seats booked for " + customerName + " at Screen " + screenNumber);
	}
	void display() {
        System.out.println("Screen: " + screenNumber + " | Movie: " + movieName + " | Available: " + availableSeats + "/" + totalSeats);
    }
}

class ScreenOne extends CinemaScreen{

	ScreenOne(int seats) {
		super(1, "Avatar", seats);
		// TODO Auto-generated constructor stub
	}
	
}

class ScreenTwo extends CinemaScreen{

	ScreenTwo(int seats) {
		super(2, "Titanic", seats);
		// TODO Auto-generated constructor stub
	}
	
}


public class CinemaScreenSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ScreenOne s1 = new ScreenOne(100);
        ScreenTwo s2 = new ScreenTwo(50);
        try {
            s1.display();
            s1.bookTickets("UserA", 40);
            s1.bookTickets("UserB", 70); // Triggers Exception
        } catch (SeatsNotAvailableException e) {
            System.out.println(e.getMessage());
        }
        s1.display();
	}

}
