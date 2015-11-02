package no.hib.dat152.ex10.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hib.dat152.ex10.model.Description;
import no.hib.dat152.ex10.model.ProductDAO;
import no.hib.dat152.ex10.util.LanguageSettings;

@WebServlet("/Kurv")
public class KurvServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public KurvServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		String handlekurv = "";
		
		//Ser etter handlekurv cookien
		for(Cookie cookie : cookies) {
			
		    if (cookie.getName().equals("kkas_handlekurv")) {
		        handlekurv = cookie.getValue();
		    }
		}
		
		String[] handleListe = handlekurv.split(",");
		
		ProductDAO pDAO = new ProductDAO(LanguageSettings.getLocale(request, response).getLanguage());
		Description gjeldende = null;
		ArrayList<HashMap<String,String>> tilJsp = new ArrayList<HashMap<String,String>>();
		HashMap<String, String> produktDetaljer = null;
		
		int i = 0;
		String gjeldendeId = "";
		
		for (String produktId : handleListe) {
			
			produktDetaljer = new HashMap<String,String>();
			System.out.println("Henter map med pno" + produktId);
			gjeldende = pDAO.getMap().get(new Integer(produktId));
			
		
			System.out.println("en verdi: " + gjeldende.getpName());
			Integer pId = new Integer(produktId);
			
			String antall = "1";
			
			if (produktDetaljer.containsKey("navn")) {
				antall = produktDetaljer.get(pId);
				produktDetaljer.put("antall", Integer.toString(new Integer(antall+1)));
			}
			
			else {
				produktDetaljer.put("pno", Integer.toString(gjeldende.getPno()));
				produktDetaljer.put("navn", gjeldende.getpName());
				produktDetaljer.put("beskrivelse", gjeldende.getText());
				produktDetaljer.put("pris", Double.toString(gjeldende.getPriceInEuro()));
				produktDetaljer.put("antall", antall);
			}
			
			if (i!=0 && gjeldendeId.equals(produktId)) {
				tilJsp.add(produktDetaljer);
			}
			
			gjeldendeId = produktId;
			
			i++;
		}
		
		
		String lang = LanguageSettings.getLocale(request, response).getLanguage();
		
		request.setAttribute("language", LanguageSettings.getLocale(request, response).getLanguage());
		request.setAttribute("lang", lang);
		request.setAttribute("produkter", tilJsp);
		request.getRequestDispatcher("kurv.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String produktId = request.getParameter("produkt");
		
		Cookie[] cookies = request.getCookies();
		String handlekurv = "";
		
		//Ser etter handlekurv cookien
		for(Cookie cookie : cookies){
		    if(cookie.getName().equals("kkas_handlekurv")){
		        handlekurv = cookie.getValue();
		    }
		}
		
		if (handlekurv.length()!=0) {
			handlekurv += "," + produktId;
		}
		
		else {
			handlekurv = produktId;
		}
		
		Cookie cookie = new Cookie("kkas_handlekurv", handlekurv);
		response.addCookie(cookie);
		response.sendRedirect("Kurv");

	}

}
