package example.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import example.db.WeatherData;
import example.pojo.DataWeather;
import example.pojo.Forecasts;
import example.pojo.MyPojo;

/**
 * Servlet implementation class SimpleServlet
 */
@WebServlet("/SimpleServlet")
public class SimpleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().print("Hello World!");
       
        
       // System.out.println(info);
		
		/* try{
				Class.forName("com.mysql.jdbc.Driver");
	    		String connection =(String) json.get("jdbcurl")+"?useSSL=false";
	    		//Connection con = DriverManager.getConnection("jdbc:mysql://sensorinstance.cnrgydi8gqco.us-west-1.rds.amazonaws.com:3306/sensordb?useSSL=false", "admin","adminadmin");
	    		Connection con = DriverManager.getConnection(connection,(String)json.get("username"),(String)json.get("password"));
	    		Statement st = con.createStatement();
	    		con.close();
	    		}
	    		catch(Exception e){
	    			e.printStackTrace();
	    		}
		*/
        String logi = request.getParameter("log");
        String latt = request.getParameter("lat");
        String place = request.getParameter("place");
        
        System.out.println("logi "+logi);
        System.out.println("latt "+latt);
        System.out.println("place "+place);
        
        
        WeatherData wd =new WeatherData();
        MyPojo pojo = wd.getdata(latt,logi);
        
        ArrayList<DataWeather> forcast = new ArrayList<DataWeather>();
         
       
        for(Forecasts p : pojo.getForecasts())
        {
        	/*if(i!=0)
        	{*/	
        	DataWeather tempdw = new DataWeather();
        	
        	String[] date = p.getFcst_valid_local().split("T");
        	String[] d = date[0].split("-");
        	/*System.out.println("date"+date[0]);
        	System.out.println("d0" +d[0]);
        	System.out.println("d1" +d[1]);
        	System.out.println("d2" +d[2]);*/
        	
        	String datevalue = convertinDate(d[0],d[1],d[2]);
        	
        	tempdw.setDate(datevalue);
        	System.out.println(p.getDay());
        	if(p.getDay()!=null)
        		{	
        			tempdw.setDaytemp(p.getDay().getTemp());
        			tempdw.setShortcast(p.getDay().getShortcast());
        			tempdw.setDay_part_name(p.getDay().getDaypart_name());
        		}
        	else
        		{
        			tempdw.setDaytemp("-");
        			tempdw.setDay_part_name("Today");
        			tempdw.setShortcast(p.getNight().getShortcast());
        			
        		}
        	tempdw.setNighttemp(p.getNight().getTemp());
        	
        	
        	tempdw.setNight_part_name(p.getNight().getDaypart_name());
        	forcast.add(tempdw);
        	/*}
        	i++;*/
       /* System.out.println("==================================");
        	System.out.println(tempdw.getDate());
        	System.out.println(tempdw.getShortcast());
        	System.out.println(tempdw.getDay_part_name());
        	System.out.println(tempdw.getDaytemp());
        	System.out.println(tempdw.getNight_part_name());
        	System.out.println(tempdw.getNighttemp());
        	System.out.println("==================================");
        */
        
        
        }
        
     /*   System.out.println(pojo);*/
        
        
        request.setAttribute("hi", "hi");
        request.setAttribute("data", forcast);
        request.setAttribute("place", place);
        
      
        RequestDispatcher dispatcher = request.getRequestDispatcher("test.jsp");
        dispatcher.forward(request, response);
        
       
     
        
    }

    
    private String convertinDate(String string, String string2, String string3) {
		
    	String date= null;
    	
    	switch(Integer.parseInt(string2))
    	{
    	
    	case 1 :   date = "January " + string3 + ", " + string; break;  
    	case 2 :	date = "February " + string3 + ", " + string; break;
    	case 3 :date = "March " + string3 + ", " + string; break;
    	case 4 :date = "April " + string3 + ", " + string; break;
    	case 5 :date = "May " + string3 + ", " + string; break;
    	case 6 :date = "June " + string3 + ", " + string; break;
    	case 7 :date = "July " + string3 + ", " + string; break;
    	case 8 :date = "August " + string3 + ", " + string; break;
    	case 9 :date = "September " + string3 + ", " + string; break;
    	case 10 :date = "Octomber " + string3 + ", " + string; break;
    	case 11 :date = "November " + string3 + ", " + string; break;
    	case 12 :date = "December " + string3 + ", " + string; break;
    	default : date = "No Date";
    	}
    	
    	
		return date;
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    	
    	doGet(request, response);
    	
    	
    }
}
