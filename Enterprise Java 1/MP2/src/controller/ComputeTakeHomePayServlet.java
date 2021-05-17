package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmployeeBean;

public class ComputeTakeHomePayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String code = request.getParameter("salesCode");
		double saleAmount = Double.parseDouble(request.getParameter("saleAmount"));
		
		EmployeeBean employee = new EmployeeBean(id,name,code,saleAmount);
		
		employee.computeTakeHomePay();
			
		request.setAttribute("employee", employee);
		
		RequestDispatcher dispatch = request.getRequestDispatcher("display.html");
		
		dispatch.forward(request, response);
		
		
	}
}
