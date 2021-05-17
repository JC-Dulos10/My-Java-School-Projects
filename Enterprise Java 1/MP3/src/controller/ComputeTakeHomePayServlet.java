package controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;

import model.EmployeeBean;

public class ComputeTakeHomePayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ServletContext application; 
	
	public void init() throws ServletException {
		System.out.println("init () method executed.");
		
		this.application = getServletContext();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost (request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//local variables
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String code = request.getParameter("salesCode");
		double saleAmount = Double.parseDouble(request.getParameter("saleAmount"));
		
		System.out.println("ID Entered: " + id);
		System.out.println("Name Entered: " + name);
		System.out.println("Sales code Entered: " + code);
		System.out.println("Sales Amount Entered: " + saleAmount);
		
		//perform server logging
		getServletContext().log("ID Entered: " + id);
		application.log("Name Entered: " + name);
		application.log("Sales code Entered: " + code);
		application.log("Sales Amount Entered: " + saleAmount);
				
		EmployeeBean employee = new EmployeeBean(id,name,code,saleAmount, getServletContext());
		
		employee.computeTakeHomePay();
		
		//Cookie part
		Cookie cookieId = new Cookie("employeeId", employee.getId());
		Cookie cookieName = new Cookie("employeeName", employee.getName());
		Cookie cookieSalesCode = new Cookie ("salesCode", employee.getCode());
		Cookie cookieSalesAmount = new Cookie ("salesAmount", new Double (employee.getSaleAmount()).toString());
		Cookie cookieTakeHomePay = new Cookie ("takeHomePay", new Double (employee.getTakeHomePay()).toString());
		Cookie cookieGrossEarned = new Cookie("grossEarned", new Double(employee.getGrossEarned()).toString());
		Cookie cookieSaleCommission = new Cookie("salesCommission", new Double(employee.getSaleCommission()).toString());

		
		
		//3 months validity
		cookieId.setMaxAge(14 * 24 * 60 * 60);
		cookieName.setMaxAge(14 * 24 * 60 * 60);
		cookieSalesCode.setMaxAge(14 * 24 * 60 * 60);
		cookieSalesAmount.setMaxAge(14 * 24 * 60 * 60);
		cookieTakeHomePay.setMaxAge(14 * 24 * 60 * 60);
		cookieGrossEarned.setMaxAge(14 * 24 * 60 * 60);
		cookieSaleCommission.setMaxAge(14 * 24 * 60 * 60);
		
		
		response.addCookie(cookieId);
		response.addCookie(cookieName);
		response.addCookie(cookieSalesCode);
		response.addCookie(cookieSalesAmount);
		response.addCookie(cookieTakeHomePay);
		response.addCookie(cookieGrossEarned);
		response.addCookie(cookieSaleCommission);
		
		response.getWriter().print("<p>Please click <a href='display.html'>here</a> to continue</p>");
		
	}
}
