package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ComputeGradeServlet
 */
@WebServlet("/computeSales.action")
public class ComputeTakeHomePayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private String code;
	private double saleAmount;
	private double takeHomePay;
	private double grossEarned;
	private double saleCommission;
	
	
	
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		id="";
		name="";
		code="";
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroy method  activated");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.id = request.getParameter("id");
		this.name = request.getParameter("name");
		this.code = request.getParameter("salesCode");
		this.saleAmount = Double.parseDouble(request.getParameter("saleAmount"));
		
		computeTakeHomePay();
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<head><title>Grade Computation</title></head>");
		out.print("<body>");
		out.print("<h2>Grade Computation</h2>");
		out.print("<p>Employee ID: " + this.id + "</p>");
		out.print("<p>Employee Name: " + this.name + "</p>");
		out.print("<p>Sales Code: " + this.code + "</p>");
		out.print("<p>Sales Amount: " + this.saleAmount + "</p>");
		out.print("<br><p>Take Home Pay: " + this.takeHomePay + "</p>");
		out.print("<p>&nbsp&nbsp&nbsp&nbsp Gross Earned: " + this.grossEarned + "</p>");
		out.print("<p>&nbsp&nbsp&nbsp&nbsp Sales Commission: " + this.saleCommission + "</p>");
		out.print("<hr/>");
		out.print("<form action='index.html'>");
		out.print("		<input type='submit' value='<< GO BACK >>'/>");
		out.print("</form>");
		out.print("</body>");
		out.print("</html>");
		
		out.close();
		
		
	}
	
	public void computeTakeHomePay() {
		if(this.code.equals("A")) {
			this.grossEarned = this.saleAmount*0.50 + 175;
		} else if(this.code.equals("B")) {
			this.grossEarned = this.saleAmount*0.20 + 100;
		}
		if(this.saleAmount > 2500) {
			this.saleCommission = saleAmount * 0.05;
		} else {
			this.saleCommission = 0;
		}
		this.takeHomePay = this.grossEarned + this.saleCommission;
	}

}
