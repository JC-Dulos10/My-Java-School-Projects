package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BusBean;

public class NumberCodingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//create local variables
		String busName = request.getParameter("busName");
		String plateNumber = request.getParameter("plateNumber");
		String driverAssigned = request.getParameter("driverAssigned");
		
		BusBean bus = new BusBean(busName, plateNumber, driverAssigned);
		if(bus.checkDBExist()==false) {
			bus.createDB();
		}
		
		//to check input
		System.out.println("ID entered: " + busName);
		System.out.println("Name entered: " + plateNumber);
		System.out.println("Assigned driver: " + driverAssigned);
		
		bus.findDateCoding();
		
		//to check
		System.out.println("End Number:" + bus.getEndNumber());
		System.out.println("Date Coding:" + bus.getDateCoding());
		System.out.println("Is Valid:" + bus.isValid());
		
		//insert to db
	
			
		getServletContext().setAttribute("bus", bus);
			
		if(bus.isValid() == false){
				response.sendRedirect("error.jsp");
		} else if(bus.isValid() == true) {
			if(bus.isRecordInserted()) {
				response.sendRedirect("results.jsp");
			}
		}
	}	
}
