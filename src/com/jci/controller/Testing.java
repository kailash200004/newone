package com.jci.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;


import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Testing {
	 

	public static void main(String[] args) {
		String regno ="05021200020";
		boolean zero = regno.startsWith("0");
		System.out.println("zero = "+zero);
		long reg = Long.parseLong(regno)+1;
		System.out.println("regno = "+reg);
		callAuth();
		 
	}
	
	public static void callAuth()
	{
		try {
		Unirest.setTimeouts(0, 0);
		HttpResponse<String> response = Unirest.post("https://oss.cyfuture.cloud:8443/api/auth")
		  .header("Accept", "application/vnd.ceph.api.v1.0+json")
		  .header("Content-Type", "application/json")
		  .header("Authorization", "Basic YWRtaW46Y2VwaGNlcGgxMjM=")
		  .header("Cookie", "token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJjZXBoLWRhc2hib2FyZCIsImp0aSI6ImYwNjg0OWVkLWQ5ODctNDZmZS1hYzFkLTlhNDZjY2Y4MTQ0MSIsImV4cCI6MTY2ODQ1OTQ3MSwiaWF0IjoxNjY4NDMwNjcxLCJ1c2VybmFtZSI6ImFkbWluIn0.aHOQSY1kQHPo_5Xz8tEBu-B94wI3R6cpp_3HAINu1EU")
		  .body("{\r\n    \"password\": \"cephceph123\",\r\n    \"username\": \"admin\"\r\n}")
		  .asString();
		System.out.println(response.toString());
		}
		catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
		
		
		try {
			OkHttpClient client = new OkHttpClient().newBuilder().build();
					MediaType mediaType = MediaType.parse("application/json");
					RequestBody body = RequestBody.create(mediaType, "{\r\n    \"password\": \"cephceph123\",\r\n    \"username\": \"admin\"\r\n}");
					Request request = new Request.Builder()
					  .url("https://oss.cyfuture.cloud:8443/api/auth")
					  .method("POST", body)
					  .addHeader("Accept", "application/vnd.ceph.api.v1.0+json")
					  .addHeader("Content-Type", "application/json")
					  .addHeader("Authorization", "Basic YWRtaW46Y2VwaGNlcGgxMjM=")
					  .addHeader("Cookie", "token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJjZXBoLWRhc2hib2FyZCIsImp0aSI6ImYwNjg0OWVkLWQ5ODctNDZmZS1hYzFkLTlhNDZjY2Y4MTQ0MSIsImV4cCI6MTY2ODQ1OTQ3MSwiaWF0IjoxNjY4NDMwNjcxLCJ1c2VybmFtZSI6ImFkbWluIn0.aHOQSY1kQHPo_5Xz8tEBu-B94wI3R6cpp_3HAINu1EU")
					  .build();
					Response response = client.newCall(request).execute();
		}
		catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
		
		
		try {
			 HttpURLConnection conn = null;
			   String responseclient = null;
			  String inpuluser = null;
			 inpuluser = "{\r\n    \"password\": \"cephceph123\",\r\n    \"username\": \"admin\"\r\n}";
              System.out.println(inpuluser);
              
               URL url = new URL("https://oss.cyfuture.cloud:8443/api/auth");
               System.out.println(""+url.getPath());
               (conn = (HttpURLConnection)url.openConnection()).setDoOutput(true);
               System.out.println("1");
               conn.setRequestMethod("POST");
               System.out.println("2");
               conn.setRequestProperty("Content-Type", "application/json");
               System.out.println("3");
               conn.addRequestProperty("Accept", "application/vnd.ceph.api.v1.0+json");
               conn.addRequestProperty("Authorization", "Basic YWRtaW46Y2VwaGNlcGgxMjM=");
               System.out.println("4");
               OutputStream os = conn.getOutputStream();
                System.out.println("5");
               os.write(inpuluser.getBytes());
                System.out.println("6");
               os.flush();
                System.out.println("7");
               BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                System.out.println("8");
               String output;
               while((output = br.readLine()) != null) {
            	    System.out.println("while");
                  responseclient = output;
                  //System.out.print("output = "+output.toString());
                  
               }  
		}
		catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}

	}

 
}
