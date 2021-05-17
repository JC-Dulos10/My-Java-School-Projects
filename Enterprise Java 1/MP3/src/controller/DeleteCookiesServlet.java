package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;

import utility.CookieHelper;

public class DeleteCookiesServlet extends HttpServlet {
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
			
			cookieId.setMaxAge(0);
			cookieName.setMaxAge(0);
			cookieSalesCode.setMaxAge(0);
			cookieSalesAmount.setMaxAge(0);
			cookieTakeHomePay.setMaxAge(0);
			cookieGrossEarned.setMaxAge(0);
			cookieSaleCommission.setMaxAge(0);
			
			response.addCookie(cookieId);
			response.addCookie(cookieName);
			response.addCookie(cookieSalesCode);
			response.addCookie(cookieSalesAmount);
			response.addCookie(cookieTakeHomePay);
			response.addCookie(cookieGrossEarned);
			response.addCookie(cookieSaleCommission);
		}
		response.sendRedirect("index.html");
	}
}
