package no.hib.dat152.ex10.controllers;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		for(Cookie cookie : cookies){
		    if(cookie.getName().equals("kkas_handlekurv")){
		        handlekurv = cookie.getValue();
		    }
		}
		
		String[] handleListe = handlekurv.split(",");
		
		HashMap<String, Integer> oversikt = new HashMap<String, Integer>();
		
		if (handleListe.length!=0) {
			
			//Går gjennom handlekurven
			for (String produktId : handleListe) {
				
				if (oversikt.containsKey(Integer.parseInt(produktId)) ) {
					
					//Produktet finnes allerede i handlekurven. Øker med +1
					oversikt.put(produktId, new Integer(oversikt.get(produktId))+1 );
					System.out.println("Legger til " + produktId + " ant: " + oversikt.get(produktId)+1);
				}
				
				else {
					oversikt.put(produktId, new Integer(1));
					System.out.println("Ny " + produktId + " ant: " + oversikt.get(produktId));
				}
				
			}//for
		}
		
		else {
			response.getWriter().append("Tom handlevogn");
		}
		
		//System.out.println(oversikt.toString());
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
		
		doGet(request,response);
		
		//response.getWriter().append("Handlekurv: " + handlekurv);
	}

}
