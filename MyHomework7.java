//Rachel Herman
package HW;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/MyHomework7")
public class MyHomework7 extends HttpServlet {
	private static final long serialVersionUID = 1L; 
       

    public MyHomework7() {
        super();
    }
 
    private static String getValue(HttpServletRequest request, String cookieName) {
    	Cookie[]cookies=request.getCookies();
    	if (cookies != null) {
    		for (Cookie cookie: cookies) {
    			if (cookieName.contentEquals(cookie.getName())) {
    				return cookie.getValue();
    			}
    		}
    	}
    	return null;
    }
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int week = 60*60*24*7;
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		String FGCOLOR = "black";
		String BGCOLOR = "white";
		
		String USERFGCOLOR = request.getParameter("fgcolor");
		String USERBGCOLOR = request.getParameter("bgcolor");
		

		String siteReferer = request.getHeader("referer");
		if (siteReferer != null)
		{
			String last12letters = siteReferer.substring(siteReferer.length() - 13);
			
			if (last12letters.contentEquals("ColorChooser7"))
			{
				if (getValue(request, "fgColor") != null)
				{
					FGCOLOR = USERFGCOLOR;
					Cookie fgColorCookie = new Cookie("fgColor", FGCOLOR);
					
					fgColorCookie.setMaxAge(week);
					response.addCookie(fgColorCookie);
				}
				
				if (getValue(request, "bgColor") != null)
				{
					BGCOLOR = USERBGCOLOR;
					Cookie bgColorCookie = new Cookie("bgColor", BGCOLOR);
					bgColorCookie.setMaxAge(week);
					response.addCookie(bgColorCookie);
				}
			}
	
		}
		
		else
		{
			if (getValue(request, "fgColor") != null) {
				FGCOLOR = getValue(request, "fgColor");
			}
			if (getValue(request, "bgColor") != null) {
				BGCOLOR = getValue(request, "bgColor");
			}
		}
		
		out.print("<!DOCTYPE> <HTML>\n" + 
				"<HEAD><TITLE>MyHomework7</TITLE>\n" + 
				"<style>\n" +
				"body {background-color:"+ BGCOLOR +";color:"+ FGCOLOR +";}\n" + 
				"\n" + 
				"</style>\n" + 
				"</HEAD> \n" + 
				"<BODY>\n" + 
				"\n" + 
				"<H1 ALIGN=\"CENTER\">This is a site with changing colors!!</H1>\n" + 
				"\n" + 
				"<p>If you want to choose the background and text colors go to this website:</p>\n" + 
				"<CENTER>\n" + 
				"<a href=\"ColorChooser7\">Click Here</a>\n" + 
				"</CENTER>\n" + 
				"</BODY></HTML>\n" + 
				"\n" + 
				""); 
			
		}




	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
