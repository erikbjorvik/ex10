package no.hib.dat152.ex10.util;

import java.util.Locale;
import javax.servlet.http.Cookie;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LanguageSettings {
	
	public static Locale getLocale(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		
		String language = null;
		String country = null;
		
		if (cookies!=null) {
			//Cookie er satt, prøver å hente data fra cookie.
			
			//Iterer gjennom cookielisten. Setter lang. og countr. 
			for (Cookie cook : cookies) {
				if (cook.getName().equals("_language")) {
					language = cook.getValue();
				}
				
				if (cook.getName().equals("_country")) {
					country = cook.getValue();
				}
				
			}//for
			
		}//cookie-!null
		
		
		//Sjekker om både language og country er satt
		if (language!=null && country!=null) {
			//Begge er satt, returnerer locale basert på dette.
			return (new Locale(language,country));
		}
		
		else {
			//Ikke satt, setter locale basert på http-headeren.
			return request.getLocale();
		}
		
	}//getLocale
	
}
