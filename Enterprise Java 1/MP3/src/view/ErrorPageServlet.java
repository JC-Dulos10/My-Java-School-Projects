package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ErrorPageServlet extends HttpServlet implements Message{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message = "";
		
		switch (request.getParameter("errCode")) {
			case "1" :
				message = DATA_NOT_FOUND;
				break;
			case "2" :	
				message = GENERIC_ERROR;
				break;
		}
		message+="Please click <a href='index.html'>here</a> to try again.";
		

		//We are now ready to send the response back to client
		response.setContentType("text/html"); //set the MIME type
		
		//create a PrintWriter object
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<head><title>MP3 Take Home Pay Computation</title></head>");
		out.print("<body>");
		request.getRequestDispatcher("design/header.html").include(request, response);
		out.print("	<h2>Something went wrong.</h2>");
		out.print(message);
		out.print(" <form action='index.html'>");
		out.print(" 	<input type='submit' value='<< GO BACK >>'/>");
		out.print(" </form>");
		
		request.getRequestDispatcher("design/footer.html").include(request, response);
		
		out.print("</body>");
		out.print("</html>");
		out.close();
	}

}
