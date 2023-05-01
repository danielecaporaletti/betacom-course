package it.betacom.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.betacom.service.PetShopUserDAO;

/**
 * Servlet implementation class DisabilitaUtenteServlet
 */
@WebServlet("/DisabilitaUtenteServlet")
public class DisabilitaUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisabilitaUtenteServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        PetShopUserDAO petShopUserDAO = new PetShopUserDAO();
        petShopUserDAO.setDisable(id);

        response.sendRedirect("ListaPetShopUserServlet");
	}

}
