package com.example.setarehn.phage;

import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class JSONParser {
	
	  public String pars(String url) {
	        String result = "";
	        InputStream inputStream;

	        try {
	        	System.out.println("connecttttttttt");
	            url = url.replace(" ","%20");
	            HttpClient client = new DefaultHttpClient();
				System.out.println("connecttttttttt1");
	            HttpGet request = new HttpGet(url);
				System.out.println("connecttttttttt2");
	            HttpResponse response = client.execute(request);
	            HttpEntity entity = response.getEntity();
	            inputStream = entity.getContent();
	            System.out.println("connecttttttttt");
	        } catch (Exception e) {
	            Log.e("ss-", "Error in http connection" + e.toString());

	            return "Error in http connection";
	        }
	        try {
	            BufferedReader reader = new BufferedReader(new 
	InputStreamReader(inputStream, "utf-8"), 8);

	            String line = reader.readLine();
	            while (line != null) {

	                result = result + line;
	                line = reader.readLine();
	            }
	            inputStream.close();

	            return result;
	        } catch (Exception e) {
	            Log.e("log-", "Can not converting data" + e.toString());
	            return "Can not converting data";
	        }
	    }

}
