import javax.swing.*; 

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.*; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class WeatherAppWindow extends JFrame implements ActionListener 
{ 
	
	//JLabel textLabel = new JLabel("Hello World!");
	//JLabel textLabel2 = new JLabel("And Goodbye!");
	JLabel CurrentTemperature = new JLabel();
	
	JTextField SearchedLocation = new JTextField("",20);
	JButton SearchButton = new JButton("Search");
	
	JPanel SearchBoxPanel = new JPanel();
	JPanel CenterPanel = new JPanel(new GridLayout(2,2,0,0));
	JPanel CurrentWeatherPanel = new JPanel();
	JPanel FutureWeatherPanel = new JPanel(new GridLayout(2,1,0,0));
		JPanel UpcomingHoursWeatherPanel = new JPanel(new FlowLayout());
		JPanel UpcomingDaysWeatherPanel = new JPanel(new GridLayout(1,7,0,0));
		
	JScrollPane WeatherHoursSPanel = new JScrollPane(UpcomingHoursWeatherPanel);
	JScrollPane WeatherDaysSPanel = new JScrollPane(UpcomingDaysWeatherPanel);
       
	int WeatherParameterArray []= new int[2];
	int WeatherForecastArray []= new int[24];
	int WeatherForecast7Days[]=new int [14];
	
	public WeatherAppWindow() 
	{ 
		//Create your window. 
		super("Hello World program"); 
		setSize(1000,500); 	//Width, Height
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE); 
		setVisible(true); 
		Container contentArea = getContentPane(); 
		//FlowLayout flowManager = new FlowLayout (); 
		//contentArea.setLayout(flowManager); 
		
		SearchBoxPanel.add(SearchedLocation);
		SearchBoxPanel.add(SearchButton);
		
		SearchedLocation.grabFocus();
		
		
		CenterPanel.add(CurrentWeatherPanel);
		CenterPanel.add(FutureWeatherPanel);
		CurrentWeatherPanel.add(CurrentTemperature);
		FutureWeatherPanel.add(WeatherHoursSPanel);
		FutureWeatherPanel.add(WeatherDaysSPanel);
		
		SearchButton.addActionListener(this);
		
		CurrentTemperature.setFont(new Font(CurrentTemperature.getName(),Font.PLAIN,50));
		CurrentTemperature.setHorizontalAlignment(JLabel.CENTER);
		CurrentTemperature.setVerticalAlignment(JLabel.CENTER);
		
		WeatherHoursSPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		WeatherHoursSPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		WeatherHoursSPanel.setBorder(null);
		WeatherHoursSPanel.setBounds(50, 30, 1000, 50);
		WeatherDaysSPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		WeatherDaysSPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		WeatherDaysSPanel.setBounds(50, 30, 1000, 50);
		WeatherDaysSPanel.setBorder(null);
		
		//Create Interface components or adds
		contentArea.add("Center",CenterPanel);
		contentArea.add("North",SearchBoxPanel); 
		
		//Apply Interface components to the container. 
		setContentPane(contentArea); 
	} 

	public void RetrieveData(String adressLocation){
		Weather.RetrieveData(Weather.getCoordinates(adressLocation));
		WeatherParameterArray=Weather.Parameters(0);
	}
	
	public void CreatePanel(int temperatureLo, int temperatureHi, String Time,boolean TypeHour){
		JPanel WeatherDataPanel = new JPanel(new GridLayout(3,1,0,0));
		WeatherDataPanel.add(new JLabel(Time));
		WeatherDataPanel.add(new JLabel("Picture"));
		
		if(TypeHour){
			WeatherDataPanel.add(new JLabel(Integer.toString(temperatureHi)+"°"));
			UpcomingHoursWeatherPanel.add(WeatherDataPanel);
		}
		if(!TypeHour){
			WeatherDataPanel.add(new JLabel("Lo:"+Integer.toString(temperatureLo)+"° "+Integer.toString(temperatureHi)+"°"));
			UpcomingDaysWeatherPanel.add(WeatherDataPanel);
		}
		
	}
	
	public void SetCurrentWeather(){
		CurrentTemperature.setText(Integer.toString(WeatherParameterArray[0])+"°C");
		System.out.println(CurrentTemperature.getText());
		int[] tempWeatherForecastArray=Weather.UpcomingHoursForecast(1, 24);
		int[] tempWeatherForecast7Days=Weather.UpcomingDaysForecast();
		Calendar calendar= Calendar.getInstance();
		int HourOfDay = calendar.HOUR_OF_DAY-2;
		int DayOfWeek = calendar.DAY_OF_WEEK-2;
		DateFormatSymbols dfs = new DateFormatSymbols();
		
		
		for(int hour=0;hour<23;hour++){
			HourOfDay++;
			String SHourOfDay;
			if(HourOfDay==24)HourOfDay=0;
			if(HourOfDay<10)SHourOfDay="0"+HourOfDay;
			else SHourOfDay=Integer.toString(HourOfDay);
			
			CreatePanel(0,tempWeatherForecastArray[2*hour],SHourOfDay,true);
		}
		
		for(int day=0;day<6;day++){
			DayOfWeek++;
			String SDayOfWeek;
			if(DayOfWeek==8)DayOfWeek=1;
			SDayOfWeek=dfs.getWeekdays()[DayOfWeek];
			
			CreatePanel(tempWeatherForecast7Days[2*day],tempWeatherForecast7Days[2*day+1],SDayOfWeek,false);
			
		}
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource()==SearchButton){
			String adress = SearchedLocation.getText();
			adress = adress.replaceAll(" ","+").replaceAll("å", "a").replaceAll("ä", "a").replaceAll("ö","o");
			RetrieveData(adress);
			SetCurrentWeather();
		}
	}
}

	

public class WeatherApp {

	public static void main(String[] args) 
	{ 
		Window HelloWindow = new WeatherAppWindow(); 
	} 
	
}
