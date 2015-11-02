package no.hib.dat152.ex10.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import no.hib.dat152.ex10.model.ProductDAO;
import no.hib.dat152.ex10.util.LanguageSettings;
import no.hib.dat152.ex10.model.Description;
import java.util.HashMap;

@WebServlet("/Products")
public class ProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ProductsServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String lang = LanguageSettings.getLocale(request, response).getLanguage();
		ProductDAO pDAO = new ProductDAO(lang);
		
		ArrayList<HashMap<String,String>> prodListe = new ArrayList<HashMap<String,String>>(); 
		HashMap<String,String> buffProdukt;
		
		for (HashMap.Entry<Integer,Description> de : pDAO.getMap().entrySet()) {
			buffProdukt = new HashMap<String,String>();
			buffProdukt.put("nummer", (Integer.toString(de.getValue().getPno())));
			buffProdukt.put("navn", de.getValue().getpName());
			buffProdukt.put("beskrivelse", de.getValue().getText());
			buffProdukt.put("bilde", de.getValue().getImageFile());
			buffProdukt.put("prisEuro", Double.toString(de.getValue().getPriceInEuro()));
			
			prodListe.add(buffProdukt);

		}
		
		request.setAttribute("language", LanguageSettings.getLocale(request, response).getLanguage());
		request.setAttribute("lang", lang);
		request.setAttribute("produkter", prodListe);
		request.getRequestDispatcher("products.jsp").forward(request, response);
		
	}


}
