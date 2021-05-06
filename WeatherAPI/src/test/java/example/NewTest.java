package example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class NewTest {
	private static HttpURLConnection connection;
	
	public static void main(String[]args){
		BufferedReader reader;
		String line;
		StringBuffer responseContent= new StringBuffer();
		try {
			URL url =  new URL("http://api.openweathermap.org/data/2.5/forecast?q=Sydney,AU&appid=863c351ceabd98cadb068908ec9d7aae");
			connection= (HttpURLConnection) url.openConnection();
			//Request setup
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(5000);
			
			int statusCode= connection.getResponseCode();
			System.out.println(statusCode);
			
			if(statusCode > 299){
				reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
				
				while((line= reader.readLine())!=null){
					responseContent.append(line);
				}
				reader.close();
			}else{
               reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				
				while((line= reader.readLine())!=null){
					responseContent.append(line);				
			  }
				reader.close();
			}
			System.out.println(responseContent.toString());
			parse(responseContent.toString());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			connection.disconnect();
		}
	}
public static String parse (String responseBody){
	JSONArray weather = new JSONArray(responseBody);
	
	for (int i = 0; i<=weather.length();i++){
	JSONObject single = new JSONObject(i);
        double tempMin =  single.gettempMin();
        double tempMax = single.gettempMax();
        String dateText= single.getdateText();
        
        System.out.println(dateText + "  "+ tempMin+ "  "+tempMax+"  ");
       }
	return null;
	
    }
}
