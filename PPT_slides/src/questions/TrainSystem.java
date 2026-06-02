package questions;

class Passenger {
	int id, age;
	String name;

	Passenger(int id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}
}

interface TrainOperations {
	void bookTicket(Passenger p);

	void cancelTicket(int passengerId) throws Exception;

	void displayDetails();
}

abstract class Train implements TrainOperations {
	int trainNumber;
	Passenger[] passengers = new Passenger[50];
	int count = 0;

	Train(int num) {
		this.trainNumber = num;
	}

	public void bookTicket(Passenger p) {
		if (count < 50) {
			passengers[count++] = p;
			System.out.println("Ticket booked for " + p.name);
		} else
			System.out.println("Train is full.");
	}

	public void cancelTicket(int id) throws Exception {
		int index = -1;
		for (int i = 0; i < count; i++) {
			if (passengers[i].id == id) {
				index = i;
				break;
			}
		}
		if (index == -1)
			throw new Exception("Error: Passenger ID " + id + " not found.");
		for (int i = index; i < count - 1; i++)
			passengers[i] = passengers[i + 1];
		passengers[--count] = null;
		System.out.println("Ticket Cancelled for ID: " + id);
	}

	public void displayDetails() {
		System.out.println("Train Number: " + trainNumber + " | Passengers: " + count);
		for (int i = 0; i < count; i++) {
			System.out.println("ID: " + passengers[i].id + " | Name: " + passengers[i].name);
		}
	}
}

class ExpressTrain extends Train {
	ExpressTrain(int n) {
		super(n);
	}
}

public class TrainSystem {

}
