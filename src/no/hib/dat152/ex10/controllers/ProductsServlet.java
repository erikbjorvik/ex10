package no.hib.dat152.ex10.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hib.dat152.ex10.model.ProductDAO;
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
		String lang = LanguageSettings.getLocale(request, response).getLanguage();
		ProductDAO pDAO = new ProductDAO(lang);
		
		System.out.println(pDAO.getMap().get(1).getLangCode());
		
		request.setAttribute("lang", lang);
		request.setAttribute("produkter", pDAO.getMap());
		request.getRequestDispatcher("products.jsp").forward(request, response);
		
	}


}
