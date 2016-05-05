package example.db;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.fasterxml.jackson.databind.ObjectMapper;

import example.pojo.MyPojo;

public class WeatherData {

	public MyPojo getdata(String latt,String logi) throws MalformedURLException {
		// TODO Auto-generated method stub
		
		MyPojo pojo = null;
		
		String d = "https://twcservice.mybluemix.net:443/api/weather/v2/forecast/daily/10day?units=m&geocode="+latt+"%2C"+logi+"&language=en-US";
			URL url = new URL(d);
		
		
		//HttpURLConnection conn;
		try {
			
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		//	URLConnection conn = new URL(a).openConnection();
			conn.setRequestMethod("GET");
			//conn.setRequestProperty("Accept", "application/json");
		//	InputStream response = conn.getInputStream();
			
			String username="441fb1fa-51bd-4bac-9955-3bb5b670db47";
			String password="oPGIf0NNhL";
			String userpass = username + ":" + password;
			String basicAuth = "Basic " + javax.xml.bind.DatatypeConverter.printBase64Binary(userpass.getBytes());

//			String basicAuth = "Basic " + new String(new Base64().encode(userpass.getBytes()));
			conn.setRequestProperty ("Authorization", basicAuth);
			
			
		if (conn.getResponseCode() != 200) {
			
			System.out.println(conn.getErrorStream());
			
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}
			
			//System.out.println(conn.getResponsecode());
			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			StringBuffer buffer = new StringBuffer();
				String output;
				System.out.println(br.toString());
				System.out.println("Output from Server .... \n");
				
				while ((output = br.readLine()) != null) {
					System.out.println(output);
					buffer.append(output);
				}

				ObjectMapper mapper = new ObjectMapper();
				
				
				pojo = mapper.readValue(buffer.toString(), MyPojo.class);
				//System.out.println("Temp = "+mypojo.getObservation().getMetric().getTemp());
				//System.out.println("Visibility = "+mypojo.getObservation().getMetric().getVis());
				
				conn.disconnect();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	
		}
	
		return pojo;
		
		
	}

	
	
}
