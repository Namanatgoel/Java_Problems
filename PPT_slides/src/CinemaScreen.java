
class CinemaScreen implements Bookable {
	int screenNumber, totalSeats, availableSeats;
	String movieName;

	CinemaScreen(int num, String movie, int total) {
		this.screenNumber = num;
		this.movieName = movie;
		this.totalSeats = total;
		this.availableSeats = availableSeats;
	}

	@Override
	public void BookTickets(String name, int seats) throws my_exp {
		// TODO Auto-generated method stub
		if (seats > availableSeats)
			throw new my_exp("Not enough seats on Screen" + screenNumber);
		availableSeats -= seats;
		System.out.println("Confirmed: " + seats + " seats for " + name + " (Movie: " + movieName + ")");
	}

	void display() {
		System.out.println("Screen " + screenNumber + " | Movie: " + movieName + " | Available: " + availableSeats);
	}
}
