package com.controller.openWeather;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.controller.weatherApi.WeatherApi;
import com.entities.Location;
import com.entities.Weather;
import com.mail.MyConstants;
import com.repositories.LocationRepository;
import com.repositories.WeatherRepository;

@CrossOrigin
@Controller
public class OpenWeatherController {
	@Autowired
	private LocationRepository locationRepository;
	@Autowired
	private WeatherRepository weatherRepository;
	@Autowired
	private JavaMailSender emailSender;
	
	@GetMapping("/showWeather")
	@ResponseBody
	public void hello() {
		List<Location> locations = locationRepository.findAll();
		List<Weather> meteos = weatherRepository.findAll();
		
		String API_KEY = "1fd28c766b94f407f38119f09bf710da";
		String LOCATION = locations.get(0).getName();
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
			Map<String,Object> respMap= WeatherApi.jsonToMap(result.toString());
			Map<String, Object> mainMap= WeatherApi.jsonToMap(respMap.get("main").toString());
			Map<String, Object> windMap= WeatherApi.jsonToMap(respMap.get("wind").toString());
			System.out.println("Current temperature :"+(Long) Math.round((double) mainMap.get("temp")));
			if((Long) Math.round((double) mainMap.get("temp")) >= meteos.get(0).getTemperature()) {
				System.out.println("----------");
				MimeMessage message = emailSender.createMimeMessage();
				 
		        boolean multipart = true;
		         
		        MimeMessageHelper helper = new MimeMessageHelper(message, multipart, "utf-8");
		         
		        String htmlMsg = "<h3>Im testing send a HTML email</h3>"
		                +"<img src='http://www.apache.org/images/asf_logo_wide.gif'>";
		         
		        message.setContent(htmlMsg, "text/html");
		         
		        helper.setTo(MyConstants.FRIEND_EMAIL);
		         
		        helper.setSubject("Test send HTML email");
		         
		     
		        this.emailSender.send(message);
		 
		        System.out.println("Email Sent!");

			}
			System.out.println("Current temperature :"+mainMap.get("temp"));
			System.out.println("Current Humidity :"+mainMap.get("humidity"));
			System.out.println("Wind Speeds :"+windMap.get("speed"));
			System.out.println("Wind Angle :"+windMap.get("deg"));
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	
}

