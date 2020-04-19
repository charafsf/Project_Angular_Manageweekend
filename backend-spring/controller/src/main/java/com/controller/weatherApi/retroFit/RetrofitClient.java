package com.controller.weatherApi.retroFit;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
	public static Retrofit instance;
	
	public static Retrofit getInstance() {
		
		if(instance == null ) {
			OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
			instance = new Retrofit.Builder()
					.baseUrl("")
					.addConverterFactory(GsonConverterFactory.create())
					.client(httpClient.build())
					.build();
		}
		return instance;
	}
	/*
	 * 
	 System.out.println("----1 ----------");
			System.out.println("----- 2 ----------"+respMap.get("cod"));
			List<Object> obj = (List) respMap.get("list");
			System.out.println("size = "+obj.get(0));
			Map<String, Object> test = (Map<String, Object>) obj.get(30);
			System.out.println("dt--------"+convertUnicToDate( (double) test.get("dt")));
			System.out.println("main--------"+test.get("main"));
			Map<String, Object> main = (Map<String, Object>) test.get("main");
			System.out.println("temp = "+main.get("temp"));
			Map<String, Object> cod=  jsonToMap ( respMap.get("cod").toString());
			System.out.println("------ 3 ----------");
	 
	 *public static String convertUnicToDate(double dt) {
		Date date = new Date((long) (dt*1000L));
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm EEEEE dd MMM yyyy");
		String formated = sdf.format(date);
		return formated;
	}
	
	 */
}
