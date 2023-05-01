package it.betacom.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.betacom.entity.Animale;
import it.betacom.service.AnimaleDAO;

/**
 * Servlet implementation class ListaAnimaliServlet
 */
@WebServlet("/ListaAnimaliServlet")
public class ListaAnimaliServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaAnimaliServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AnimaleDAO animaleDao = new AnimaleDAO();
        List<Animale> animali = animaleDao.findAll();
        
        request.setAttribute("animali", animali);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("listaAnimali.jsp");
        dispatcher.forward(request, response);
	}


}
