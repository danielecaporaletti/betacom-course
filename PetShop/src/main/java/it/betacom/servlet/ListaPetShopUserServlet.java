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

@WebServlet("/ListaPetShopUserServlet")
public class ListaPetShopUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ListaPetShopUserServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PetShopUserDAO petShopUserDAO = new PetShopUserDAO();
        List<PetShopUser> userList = petShopUserDAO.findAll();
        request.setAttribute("userList", userList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("listaPetShopUser.jsp");
        dispatcher.forward(request, response);
    }
}
