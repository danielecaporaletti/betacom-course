package it.betacom.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.betacom.entity.PetShopUser;
import it.betacom.entity.PetShopUser.UseRole;
import it.betacom.entity.PetShopUser.UseStatus;
import it.betacom.service.PetShopUserDAO;

/**
 * Servlet implementation class ModificaUtenteServlet
 */
@WebServlet("/ModificaUtenteServlet")
public class ModificaUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificaUtenteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PetShopUserDAO petShopUserDAO = new PetShopUserDAO();
        List<PetShopUser> userList = petShopUserDAO.findAll();
        request.setAttribute("userList", userList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("modificaUtente.jsp");
        dispatcher.forward(request, response);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UseRole role = UseRole.valueOf(request.getParameter("role"));
        UseStatus status = UseStatus.valueOf(request.getParameter("status"));
        String nome = request.getParameter("nome");
        String cognome = request.getParameter("cognome");
        String telefono = request.getParameter("telefono");

        PetShopUser updatedUser = new PetShopUser(username, password, role, status, nome, cognome, telefono);
        updatedUser.setId(id);

        PetShopUserDAO petShopUserDAO = new PetShopUserDAO();
        petShopUserDAO.update(updatedUser);

        response.sendRedirect("ListaPetShopUserServlet");
	}

}
