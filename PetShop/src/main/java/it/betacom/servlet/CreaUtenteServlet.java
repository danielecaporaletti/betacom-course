package it.betacom.servlet;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
 * Servlet implementation class CreaUtenteServlet
 */
@WebServlet("/CreaUtenteServlet")
public class CreaUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreaUtenteServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        
        if (!isValidEmail(email)) {
            // Se l'email non è valida, mostra un messaggio di errore e reindirizza al form di registrazione
            request.setAttribute("errorMessage", "L'indirizzo email inserito non è valido.");
            request.getRequestDispatcher("nuovoUtente.jsp").forward(request, response);
            return;
        }

        String password = request.getParameter("password");
        UseRole role = UseRole.valueOf(request.getParameter("role"));
        UseStatus status = UseStatus.valueOf(request.getParameter("status"));
        String nome = request.getParameter("nome");
        String cognome = request.getParameter("cognome");
        String telefono = request.getParameter("telefono");

        PetShopUser newUser = new PetShopUser(email, password, role, status, nome, cognome, telefono);
        newUser.setChangePwd("Y");
        
        PetShopUserDAO petShopUserDAO = new PetShopUserDAO();
        petShopUserDAO.create(newUser);

        response.sendRedirect("ListaPetShopUserServlet");
    }
	
	private boolean isValidEmail(String email) {
	    String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
	    Pattern pattern = Pattern.compile(emailRegex);
	    Matcher matcher = pattern.matcher(email);
	    return matcher.matches();
	}

}
