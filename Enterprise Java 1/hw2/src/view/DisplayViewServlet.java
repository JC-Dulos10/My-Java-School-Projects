package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmployeeBean;

/**
 * Servlet implementation class DisplayViewServlet
 */
@WebServlet("/display.html")
public class DisplayViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EmployeeBean employee = (EmployeeBean) request.getAttribute("employee");
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<head><title>Grade Computation</title></head>");
		out.print("<body>");
		out.print("<h2>Grade Computation</h2>");
		out.print("<p>Employee ID: " + employee.getId() + "</p>");
		out.print("<p>Employee Name: " + employee.getName() + "</p>");
		out.print("<p>Sales Code: " + employee.getCode() + "</p>");
		out.print("<p>Sales Amount: " + employee.getSaleAmount() + "</p>");
		out.print("<br><p>Take Home Pay: " + employee.getTakeHomePay() + "</p>");
		out.print("<p>&nbsp&nbsp&nbsp&nbsp Gross Earned: " + employee.getGrossEarned() + "</p>");
		out.print("<p>&nbsp&nbsp&nbsp&nbsp Sales Commission: " + employee.getSaleCommission() + "</p>");
		out.print("<hr/>");
		out.print("<form action='index.html'>");
		out.print("		<input type='submit' value='<< GO BACK >>'/>");
		out.print("</form>");
		out.print("</body>");
		out.print("</html>");
		
		out.close();
		
	}

}
