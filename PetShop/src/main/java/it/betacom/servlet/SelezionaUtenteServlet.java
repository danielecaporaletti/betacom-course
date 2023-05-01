package it.betacom.servlet;

import it.betacom.entity.PetShopUser;
import it.betacom.service.PetShopUserDAO;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SelezionaUtenteServlet")
public class SelezionaUtenteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public SelezionaUtenteServlet() {
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        PetShopUserDAO petShopUserDAO = new PetShopUserDAO();
        PetShopUser user = petShopUserDAO.findById(userId);
        
        // Get the full list of users for the dropdown menu
        List<PetShopUser> userList = petShopUserDAO.findAll();
        request.setAttribute("userList", userList);
        
        request.setAttribute("user", user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("modificaUtente.jsp");
        dispatcher.forward(request, response);
    }
}
