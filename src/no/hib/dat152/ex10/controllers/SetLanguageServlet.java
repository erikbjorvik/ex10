package no.hib.dat152.ex10.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hib.dat152.ex10.util.LanguageSettings;

/**
 * Servlet implementation class SetLanguageServlet
 */
@WebServlet("/SetLanguage")
public class SetLanguageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetLanguageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String[] langDeler = request.getParameter("SetLang").split("-");
		LanguageSettings.setLangCookie(langDeler[0], langDeler[1], response);
		response.sendRedirect(request.getHeader("referer"));
	}

}
