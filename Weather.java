import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.ImageIcon;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

class Weather{

	static JSONArray timeSeriesArray;
	static boolean laterForecast=false;
	//@SuppressWarnings("unchecked")
	
	public static String[] getCoordinates(String adressLocation){
		String[] coordinates = new String [3]; //[latitude, longitude]
		String GeoLocationUrlLink = "https://maps.googleapis.com/maps/api/geocode/json?address="+adressLocation+"&key=AIzaSyD4h-K38ktsMIbnDb_JO9moIvGFTEFfzcI";
		//System.out.println(GeoLocationUrlLink);
		try{
			URL url = new URL (GeoLocationUrlLink); //Creates a link
			URLConnection dataSource = url.openConnection(); //Connects to Google Maps API server
			dataSource.connect();
			JSONParser parsedJSON = new JSONParser();
			//Retrieves the content from the API as a JSONObject
			JSONObject retrievedContent;
			//try{
				retrievedContent = (JSONObject) parsedJSON.parse(new InputStreamReader((InputStream) dataSource.getContent()));
			//} catch	(MalformedURLException e){
				//System.out.print("problem");
			//}
			//Retrieving all results of the location
			JSONArray GeoLocationResults = (JSONArray) retrievedContent.get("results");
			//Retrieving the Data
			JSONObject GeoLocationData = (JSONObject) GeoLocationResults.get(0);
			JSONObject GeoLocationGeometry  = (JSONObject) GeoLocationData.get("geometry");
			//Retrieving the coordination and rounding the value so it works with SMHI API
			JSONObject GeoLocationCoordination = (JSONObject) GeoLocationGeometry.get("location");
			coordinates[0] = Double.toString(Math.round(((Double) GeoLocationCoordination.get("lat"))*100.0)/100.0);
			coordinates[1] = Double.toString(Math.round(((Double) GeoLocationCoordination.get("lng"))*100.0)/100.0);
			JSONArray AddressComponent  = (JSONArray) GeoLocationData.get("address_components");
			for(int rounds=0;rounds<AddressComponent.size()-1;rounds++){
				JSONObject element0 = (JSONObject) AddressComponent.get(rounds);
				JSONArray typesArray = (JSONArray) element0.get("types");
				if(typesArray.get(0).equals("locality")){
					coordinates[2]=(String) element0.get("long_name");
				}
				if(typesArray.size()>1){
					if(typesArray.get(1).equals("sublocality")){
						coordinates[2]=(String) element0.get("long_name");
					}
				}
			}
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
			System.out.println("Wrong link");
		} catch (IOException e){
			//e.printStackTrace();
			System.out.println("No internet");
		} catch (ParseException e) {
			e.printStackTrace();
			System.out.println("W");
		}
		return coordinates;
	}
	
	public static void RetrieveData(String coordinates[]){
		String WeatherUrlLink = "https://opendata-download-metfcst.smhi.se/api/category/pmp3g/version/2/geotype/point/lon/"+coordinates[1]+"/lat/"+coordinates[0]+"/data.json";
		System.out.println(WeatherUrlLink);
		try {
			URL url = new URL (WeatherUrlLink); //Creates a link
			URLConnection dataSource = url.openConnection(); //Connects to SMHI's server
			dataSource.connect();
			JSONParser parsedJSON = new JSONParser();
			//Retrieves the content from the API as a JSONObject
			JSONObject retrievedContent;
			//try{
				retrievedContent = (JSONObject) parsedJSON.parse(new InputStreamReader((InputStream) dataSource.getContent()));
			//} catch	(MalformedURLException e){
				//System.out.print("problem");
			//}
				
			//Retrieves the JSONObject which contain the weather parameters as Array
			timeSeriesArray = (JSONArray) retrievedContent.get("timeSeries");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e){
			//e.printStackTrace();
			System.out.println("No internet");
		} catch (ParseException e) {
			e.printStackTrace();
		}		
	}
	
	public static int[] Parameters(int TimeReference){
		int [] WeatherParameters = new int[2]; //[Temperature, Weather type]
			
		//Latest, current weather Data. The JSONArray is turned into a JSONObject
		JSONObject currentWeatherData = (JSONObject) timeSeriesArray.get(TimeReference);
		//Retrieves the parameters from the JSONObject "parameters"
		JSONArray ParametersArray = (JSONArray) currentWeatherData.get("parameters");
		//Retrieves the information about the Temperature and type of Weather
		JSONObject temperatureObject = (JSONObject) ParametersArray.get(11);
		//Due to pattern change in the JSON file after the 6:th hour, temperature is retrieved from different element number
		if(laterForecast)temperatureObject = (JSONObject) ParametersArray.get(1);
		
		JSONObject weatherTypeObject = (JSONObject) ParametersArray.get(18);
		//The array of temperature values and weather value
		JSONArray temperatureValueArray = (JSONArray) temperatureObject.get("values");
		JSONArray weatherValueArray = (JSONArray) weatherTypeObject.get("values");
		//The JSONObject temperature is converted to a Double (object) to a double (primitive)
		double temperature = ((Double) temperatureValueArray.get(0));	//Issues everytime 
		
		
		int wholeNumber = (int) temperature;
		double decimal = temperature-wholeNumber;
		if(decimal<=-0.5&&decimal>-0.6)temperature=Math.floor(temperature);	//Rounds down when negative temperature has 0.5 as decimal
		else temperature=Math.round(temperature);
		
		//Storing the numbers in the array and returning it
		WeatherParameters[0]=(int) temperature;
		long weatherCode = ((Long) weatherValueArray.get(0));
		WeatherParameters[1] = (int) weatherCode;
		
		return WeatherParameters;
	}
	
	public static ImageIcon getWeatherImage(int WeatherCode){
		switch(WeatherCode){
		case 1:
			System.out.println("Clear Sky");
			break;
		case 2:
			System.out.println("Clear Sky");
			break;
		case 3:
			System.out.println("Halfclear Sky");
			break;
		case 4:
			System.out.println("Halfclear Sky");
			break;
		case 5:
			System.out.println("Cloudy Sky");
			break;
		case 6:
			System.out.println("Overcast");
			break;
		case 7:
			System.out.println("Fog");
			break;
		case 8:
			System.out.println("Light Rain");
			break;
		case 9:
			System.out.println("Rain");
			break;
		case 10:
			System.out.println("Rain");
			break;
		case 11:
			System.out.println("Thunderstorm");
			break;
		case 12:
			System.out.println("Light Sleet");
			break;
		case 13:
			System.out.println("Sleet");
			break;
		case 14:
			System.out.println("Sleet");
			break;
		case 15:
			System.out.println("Light Snow");
			break;
		case 16:
			System.out.println("Snow");
			break;
		case 17:
			System.out.println("Snow");
			break;
		case 18:
			System.out.println("Light Rain");
			break;
		case 19:
			System.out.println("Rain");
			break;
		case 20:
			System.out.println("Rain");
			break;
		case 21:
			System.out.println("Thunder");
			break;
		case 22:
			System.out.println("Light Sleet");
			break;
		case 23:
			System.out.println("Sleet");
			break;
		case 24:
			System.out.println("Sleet");
			break;
		case 25:
			System.out.println("Light Snow");
			break;
		case 26:
			System.out.println("Snow");
			break;
		case 27:
			System.out.println("Snow");
			break;
		}
		return null;
	}
	
	public static int[] UpcomingHoursForecast(int StartHour, int EndHour){
		int []ForecastHoursArray = new int[48]; //[Temperature, Weather Code,...]
		int TimeReference;
		int counter=0;
		if(StartHour<5){
			//Collecting data from the first 5 hours. Counter helps with in which element the data will be stored in the array
			for(TimeReference=1;TimeReference<=5;TimeReference++){
				//Retrieving data from Parameters() and alternate between storing the temperature and the Weather code
				int []tempArray=Parameters(TimeReference);
				ForecastHoursArray[2*counter]=(int) tempArray[0];
				ForecastHoursArray[2*counter+1]=(int) tempArray[1];
				counter++;
			}
		}
		/*Causes to change element number from where temperature is retrieved and starts from 
		 where previous for loop ended with help of the counter.*/
		laterForecast=true;
		for(TimeReference=StartHour+counter;TimeReference<=EndHour;TimeReference++){
			//Retrieving data and storing both temperature and weather code
			int [] tempArray=Parameters(TimeReference);
			ForecastHoursArray[2*counter]=(int) tempArray[0];
			ForecastHoursArray[2*counter+1]=(int) tempArray[1];
			counter++;
		}
		laterForecast=false;
		return ForecastHoursArray;
	}
	
	public static int []RetriveHiLowTempForecast(int StartHour){
		String StartOfDay="22:00:00Z";
		if(StartHour>=24)StartOfDay="00:00:00Z";
		String validTime=new String();
		int EndHour=StartHour;
		if(laterForecast)EndHour=StartHour; //Helps to retrieve the only two data for the 7:th day.
											//Otherwise, 4 data for two days would be retrieved.
		do{
			EndHour++;
			JSONObject WeatherData = (JSONObject) timeSeriesArray.get(EndHour);
			validTime = (String) WeatherData.get("validTime");
			validTime=validTime.substring(11);
		}while(!validTime.equals(StartOfDay));
		
		int [] ForecastDayArray=UpcomingHoursForecast(StartHour,EndHour-1);	//Retrieves the weather data from when the day starts until it ends
		int []HiLowTempArray= new int [EndHour-StartHour]; //Has all the temperature data for one day
		
		for(int i=0;i<HiLowTempArray.length;i++){
			HiLowTempArray[i]=ForecastDayArray[2*i];
		}
		return HiLowTempArray;
	}
	
	public static int [] UpcomingDaysForecast(){
		int Forecast7DaysArray[]=new int[21];	//[LowTemp,HighTemp,...] Last 7 element are weather code
		int WSymbolArray[]=new int[7];
		String StartOfDay=new String("22:00:00Z");
		String validTime=new String();
		int lowestTemp; //Stores the days' lowest temperature
		int highestTemp;	//Stores the days' highest temperature
		int BestWSymbElement=0;
		int StartHour=0;
		
		
		/*Checking in which element (counter) the String validTime in the JSON file
		  matches with is 22:00 UTC (00:00 in Sweden)*/
		do{
			StartHour++;
			JSONObject WeatherData = (JSONObject) timeSeriesArray.get(StartHour);
			validTime = (String) WeatherData.get("validTime");
			validTime=validTime.substring(11);
		}while(!validTime.equals(StartOfDay));
		
		//Retrieving upcoming 7 days' weather
		for(int day=1;day<=7;day++){
			if(day==7)laterForecast=true;//If 7:th day, boolean is true to match the change in JSONfile
			int HiLowTempArray[]=RetriveHiLowTempForecast(StartHour);
			
			BestWSymbElement=StartHour;
			do{
				BestWSymbElement++;
				JSONObject WeatherData = (JSONObject) timeSeriesArray.get(BestWSymbElement);
				validTime = (String) WeatherData.get("validTime");
				validTime=validTime.substring(11);
				if(validTime.equals("12:00:00Z")){
					int[] tempArray=Parameters(BestWSymbElement);
					WSymbolArray[day-1]=(int) tempArray[1];
					break;
				}
			}while(""!=null);
			
			highestTemp=Array.maximum(HiLowTempArray);
			lowestTemp=Array.minimum(HiLowTempArray);
			Forecast7DaysArray[2*day-2]=lowestTemp;
			Forecast7DaysArray[2*day-1]=highestTemp;
			Forecast7DaysArray[13+day]=WSymbolArray[day-1];
			StartHour=StartHour+HiLowTempArray.length; //Setting new time of which element in the array next day starts
			laterForecast=false;
		}
		return Forecast7DaysArray;
	}
}	

