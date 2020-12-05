import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LocalTime extends HttpServlet {

	public void init() throws ServletException {
		
	}
	
   public void doPost(HttpServletRequest request, 
		      HttpServletResponse response)
		      throws ServletException, IOException 
   {
	   response.setContentType("text/html");

      // Writing message to the web page
      PrintWriter out = response.getWriter();
      
      
      String sessionId = request.getParameter("trackingval");
      out.println("<html><head><title>Current Time</title></head>");
      
      out.println("<body><h1>Current Time</h1>");
      out.println("<INPUT TYPE=\"HIDDEN\" NAME=\"trackingval\" VALUE=\""+sessionId + "\"/>");
      out.println("<p>Current Time Zone: "+ request.getParameter("timezone")+ "</p>");
      TimeZone timeZone = TimeZone.getTimeZone(request.getParameter("timezone"));
      Calendar calendar = new GregorianCalendar();
      calendar.setTimeZone(timeZone);
      long timeSecs = calendar.getTimeInMillis();
      String dateString =  new String("" + 
      (calendar.get(Calendar.MONTH)+1) + "/" +
      calendar.get(Calendar.DAY_OF_MONTH) + " " +
      calendar.get(Calendar.HOUR_OF_DAY) + ":" +
      calendar.get(Calendar.MINUTE) + ":" +
      calendar.get(Calendar.SECOND));
      out.println("<p> Current Date and Time: " + dateString + "</p></body></html>");
	   
   }
	

   public void destroy() {
	   
   
   }
}
