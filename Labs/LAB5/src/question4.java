/*4. Design a Weather class with a static nested class Forecast. 
a) The Forecast class should predict weather conditions (Sunny, Rainy, Cloudy) based on 
input data like temperature and humidity. 
b) Use the nested class to predict and display the weather forecast for different cities. */
import java.util.*;
class Weather{
	Scanner sc = new Scanner(System.in);
	static class Forecast{
		double temperature;
		double humidity;
		System.out.println("Enter the temperature: ");
		temperature = sc.nextdouble();
		System.out.println("Enter the humidity: ");
		humidity = sc.nextdouble();
		System.out.println("The weather condition is: ");
		if(humidity<20.0 && temperature>30) {
			System.out.println("Sunny");
		}
		else if(humidity>20.0) {
			System.out.println("Rainy");
		}
		else System.out.println("Cloudy");
	}
}

public class question4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Weather weather = new Weather();
		
	}

}
