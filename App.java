import java.util.Calendar;
import java.util.Scanner;


public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int WeatherParameterArray []= new int[2];
		int WeatherForecastArray []= new int[48];
		int WeatherForecast7Days[]=new int [14];
		Scanner input = new Scanner(System.in); 
		
		//Input location
		System.out.println("Enter Location/Address");	
		String addressLocation = input.nextLine();
		addressLocation = addressLocation.replaceAll(" ","+").replaceAll("å", "a").replaceAll("ä", "a").replaceAll("ö","o");
		Weather.RetrieveData(Weather.getCoordinates(addressLocation));
		WeatherParameterArray= Weather.Parameters(0);
		System.out.println("Temperature, "+Calendar.getInstance().HOUR_OF_DAY+":"+Calendar.getInstance().MINUTE+" o'clock, in "+Weather.getCoordinates(addressLocation)[2]+": "+WeatherParameterArray[0]);
		System.out.println("Weather Code: "+(WeatherParameterArray[1]));
		WeatherForecastArray=Weather.UpcomingHoursForecast(1,24);
		Array.printIntArray(WeatherForecastArray);
		System.out.println("");
		WeatherForecast7Days=Weather.UpcomingDaysForecast();
		Array.printIntArray(WeatherForecast7Days);
		//System.out.println(Calendar.getInstance().DAY_OF_WEEK);
		
		
	}

}
