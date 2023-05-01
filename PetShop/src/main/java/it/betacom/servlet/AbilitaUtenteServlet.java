package it.betacom.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.betacom.service.PetShopUserDAO;

/**
 * Servlet implementation class AbilitaUtenteServlet
 */
@WebServlet("/AbilitaUtenteServlet")
public class AbilitaUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AbilitaUtenteServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        PetShopUserDAO petShopUserDAO = new PetShopUserDAO();
        petShopUserDAO.setActive(id);

        response.sendRedirect("ListaPetShopUserServlet");
	}

}
