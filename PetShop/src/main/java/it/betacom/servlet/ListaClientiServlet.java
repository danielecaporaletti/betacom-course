package it.betacom.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.betacom.entity.Cliente;
import it.betacom.service.ClienteDAO;

/**
 * Servlet implementation class ListaClientiServlet
 */
@WebServlet("/ListaClientiServlet")
public class ListaClientiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaClientiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClienteDAO clienteDAO = new ClienteDAO();
        List<Cliente> clienti = clienteDAO.findAll();
      
        request.setAttribute("clienti", clienti);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("listaClienti.jsp");
        dispatcher.forward(request, response);
	}

}
