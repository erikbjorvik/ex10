package no.hib.dat152.ex10.util;

import java.util.Locale;
import javax.servlet.http.Cookie;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LanguageSettings {
	
	/**
	 * Returnerer Localeobjekt. Dersom language og country er satt i cookie vil dette bli brukt.
	 * Ellers brukes HTTP-Accept-Language. Om ikke denne er satt vil det som er satt som standard
	 * på serveren bli brukt. 
	 * 
	 * @param request HttpServletRequest objekt
	 * @param response HttpServletResponse objekt
	 * @return Locale objekt
	 */
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
	
	/**
	 * Setter language og country cookiene.
	 * 
	 * @param lang Language som String på ISO 639 format
	 * @param country Country som String på ISO 3166 format
	 * @param response HttpServletResponse objekt
	 */
	public static void setLangCookie(String lang, String country, HttpServletResponse response) {
		response.addCookie(new Cookie("_language", lang));
		response.addCookie(new Cookie("_country", country));
	}
	
}
