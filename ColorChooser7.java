//Rachel Herman
package HW;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ColorChooser7")
public class ColorChooser7 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ColorChooser7() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String colorOptions = 
				"	 <option>Red</option>\n" + 
				"	 <option>FireBrick</option>\n" + 
				"	 <option>MediumVioletRed</option>\n" + 
				"    <option>Pink</option>\n" + 
				"    <option>Orange</option>\n" + 
				"    <option>Coral</option>\n" + 
				"    <option>Yellow</option>\n" + 
				"    <option>PeachPuff</option>\n" + 
				"    <option>Green</option>\n" + 
				"    <option >Chartreuse</option>\n" + 
				"    <option>Blue</option>\n" + 
				"    <option>Purple</option>\n" + 
				"    <option>Orchid</option>\n" + 
				"    <option >Cyan</option>\n" + 
				"    <option>Brown</option>\n" + 
				"    <option>BlanchedAlmond</option>\n" + 
				"    <option>MistyRose</option>\n" + 
				"    <option>SlateGray</option>\n";


		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		
		out.println(
		"<!DOCTYPE html>\n" + 
		"<html>\n" + 
		"<HEAD><TITLE>ColorChooser</TITLE></HEAD> <BODY BGCOLOR=\"lightBlue\">\n" + 
		"<H1 ALIGN=\"CENTER\">Choose the colors!</H1>\n" +
		
		"<body>\n" + 
		"\n" + 
		
		"<h2>Choose the colors for the other Webpage:</h2>\n" + 
	
		"<form action=\"MyHomework7\">\n" + 
		"  Text Color:\n" + 
		"<select name=\"fgcolor\">\n" + colorOptions + "</select>\n" + 
		"\n" + 
		"Background Color:\n" + 
		"<select name=\"bgcolor\">\n" + colorOptions + "</select>\n" + 
		"  <input type=\"submit\">"+
		"</form>\n" + 
		"\n" + 
		"</body>\n" + 
		"</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
