package it.betacom.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.betacom.entity.PetShopUser;
import it.betacom.service.PetShopUserDAO;

@WebServlet("/CambiaPasswordServlet")
public class CambiaPasswordServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public CambiaPasswordServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        PetShopUser user = (PetShopUser) session.getAttribute("utente");

        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");
        String confirmNewPassword = request.getParameter("confirmNewPassword");

        if (user.getPassword().equals(oldPassword)) {
            if (newPassword.equals(confirmNewPassword)) {
                PetShopUserDAO petShopUserDAO = new PetShopUserDAO();
                user.setPassword(newPassword);
                user.setChangePwd("N");
                petShopUserDAO.update(user);

                session.setAttribute("utente", user);
                response.sendRedirect("home.jsp");
            } else {
                request.setAttribute("errorMessage", "Le nuove password non corrispondono");
                request.getRequestDispatcher("cambiaPassword.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("errorMessage", "La password attuale non è corretta");
            request.getRequestDispatcher("cambiaPassword.jsp").forward(request, response);
        }
    }
}
