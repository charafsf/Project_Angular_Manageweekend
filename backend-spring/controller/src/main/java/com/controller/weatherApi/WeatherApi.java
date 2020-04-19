package com.controller.weatherApi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class WeatherApi {
	public static Map<String, Object> jsonToMap(String str){
		Map<String, Object> map = new Gson().fromJson(str, 
				new TypeToken<HashMap<String, Object>>() {}.getType());
		return map;
	}
	public static String convertUnicToDate(double dt) {
		Date date = new Date((long) (dt*1000L));
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm EEEEE dd MMM yyyy");
		String formated = sdf.format(date);
		return formated;
	}
	
	public static void main(String[] args) {
		String API_KEY = "1fd28c766b94f407f38119f09bf710da";
		String LOCATION = "Rennes";
		String urlString = "http://api.openweathermap.org/data/2.5/weather?q="+ LOCATION +"&appid="+ API_KEY + "&units=metric";
		
		try {
			StringBuilder result = new StringBuilder();
			URL url = new URL(urlString);
			URLConnection conn = url.openConnection();
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while((line = rd.readLine()) != null){
				result.append(line);
			}
			rd.close();
			System.out.println(result);
			Map<String,Object> respMap= jsonToMap(result.toString());
			Map<String, Object> mainMap= jsonToMap(respMap.get("main").toString());
			Map<String, Object> windMap= jsonToMap(respMap.get("wind").toString());
			
			System.out.println("Current temperature :"+mainMap.get("temp"));
			System.out.println("Current Humidity :"+mainMap.get("humidity"));
			System.out.println("Wind Speeds :"+windMap.get("speed"));
			System.out.println("Wind Angle :"+windMap.get("deg"));

			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}