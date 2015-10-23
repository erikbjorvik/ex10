package no.hib.dat152.ex10.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hib.dat152.ex10.util.LanguageSettings;

/**
 * Servlet implementation class Products
 */
@WebServlet("/Products")
public class ProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//ProductDAO pDao = new ProductDAO();
		//Description d1 = pDao.getDescriptionByPno(1);
		//response.getWriter().append(d1.getpName() +" "+ d1.getLangCode() ).append(request.getContextPath());
		
		response.getWriter().append("Ditt språk: " + LanguageSettings.getLocale(request, response).getLanguage());
		response.getWriter().append("Ditt land: " + LanguageSettings.getLocale(request, response).getCountry());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
