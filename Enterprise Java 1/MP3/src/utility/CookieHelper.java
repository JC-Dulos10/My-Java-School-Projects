package utility;

import javax.servlet.http.Cookie;

public class CookieHelper {

	public static Cookie getCookie(Cookie[] cookies, String targetName) {
		Cookie targetCookie = null;
		
		if (cookies != null) { //means we have the cookies from the client
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(targetName)) {
					targetCookie = cookie;
					break; 
				}
			}
		}
		return targetCookie;
	}
}
