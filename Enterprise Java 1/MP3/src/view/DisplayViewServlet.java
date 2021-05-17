package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;

import utility.CookieHelper;

public class DisplayViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cookie allCookies[] = request.getCookies();
		
		Cookie cookieId = CookieHelper.getCookie(allCookies, "employeeId");
		Cookie cookieName = CookieHelper.getCookie(allCookies, "employeeName");
		Cookie cookieSalesCode = CookieHelper.getCookie(allCookies, "salesCode");
		Cookie cookieSalesAmount = CookieHelper.getCookie(allCookies, "salesAmount");
		Cookie cookieTakeHomePay = CookieHelper.getCookie(allCookies, "takeHomePay");
		Cookie cookieGrossEarned = CookieHelper.getCookie(allCookies, "grossEarned");
		Cookie cookieSaleCommission = CookieHelper.getCookie(allCookies, "salesCommission");
		
		if (cookieId != null && cookieName != null && cookieSalesCode != null
				&& cookieSalesAmount != null && cookieTakeHomePay != null && 
				cookieGrossEarned != null && cookieSaleCommission != null) {
	
			response.setContentType("text/html");
			
			PrintWriter out = response.getWriter();
			
			out.print("<html>");
			out.print("<head><title>Take Home Pay Computation</title></head>");
			out.print("<body>");
			
			request.getRequestDispatcher("design/header.html").include(request, response);

			out.print("<p>Employee ID: " + cookieId.getValue() + "</p>");
			out.print("<p>Employee Name: " + cookieName.getValue() + "</p>");
			out.print("<p>Sales Code: " + cookieSalesCode.getValue() + "</p>");
			out.print("<p>Sales Amount: " + cookieSalesAmount.getValue() + "</p>");
			out.print("<br><p>Take Home Pay: " + cookieTakeHomePay.getValue() + "</p>");
			out.print("<p>&nbsp&nbsp&nbsp&nbsp Gross Earned: " + cookieGrossEarned.getValue() + "</p>");
			out.print("<p>&nbsp&nbsp&nbsp&nbsp Sales Commission: " + cookieSaleCommission.getValue() + "</p>");
			out.print("<hr/>");
			
			//create a form event that will delete all cookies created
			out.print(" <p><form action='clearcookies.action'>");
			out.print(" 	<input type='submit' value='Clear ALL Cookies'/>");
			out.print(" </form></p>");
			
			out.print(" <p><form action='index.html'>");
			out.print(" 	<input type='submit' value='<< GO BACK >>'/>");
			out.print(" </form></p>");
			
			request.getRequestDispatcher("design/footer.html").include(request, response);
			
			out.print("</body>");
			out.print("</html>");
			out.close();
		} else {
			response.sendRedirect("index.html");
		}
	}
}
