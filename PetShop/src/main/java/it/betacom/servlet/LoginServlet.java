package it.betacom.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.betacom.entity.PetShopUser;
import it.betacom.service.PetShopUserDAO;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        PetShopUserDAO petShopUserDAO = new PetShopUserDAO();
        PetShopUser user = petShopUserDAO.findUserByUsernameAndPasswordAndStatus(username, password);

        if (user != null) {
            if (user.getStatus() == PetShopUser.UseStatus.ACTIVE) {
                HttpSession session = request.getSession();
                session.setAttribute("utente", user);
                petShopUserDAO.resetAccessCount(user.getId());
                
                if ("Y".equals(user.getChangePwd())) {
                    response.sendRedirect("cambiaPassword.jsp");
                } else {
                    response.sendRedirect("home.jsp");
                }
            } else {
                request.setAttribute("errorMessage", "L'utente è disabilitato");
                RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                dispatcher.forward(request, response);
            }
        } else {
            PetShopUser failedUser = petShopUserDAO.findUserByUsername(username);
            if (failedUser != null) {
                int accessCount = failedUser.getAccessCount() + 1;
                failedUser.setAccessCount(accessCount);
                petShopUserDAO.update(failedUser);

                if (accessCount >= 3) {
                    petShopUserDAO.setDisable(failedUser.getId());
                }
            }
            request.setAttribute("errorMessage", "Username o password non corretti");
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        }
    }
}
