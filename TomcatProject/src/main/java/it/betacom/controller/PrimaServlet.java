package it.betacom.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PrimaServlet
 */
//@WebServlet("/PrimaServlet")
public class PrimaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final DecimalFormat FMT = new DecimalFormat("#0.00");

	private static final String PAGE_TOP = ""
	+ "<html>"
	+ "<head>"
	+ "<title>Tabella di conversione da Celsius a Fahrenheit</title>"
	+ "</head>"
	+ "<body>"
	+ "<h3>Tabella di conversione da Celsius a Fahrenheit</h3>"
	+ "<table>"
	+ "<tr>"
	+ "<th>Celsius</th>"
	+ "<th>Fahrenheit</th>"
	+ "</tr>"
	;

	private static final String PAGE_BOTTOM = ""
	+ "</table>"
	+ "</body>"
	+ "</html>"
	;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrimaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println(PAGE_TOP);
		for(double cels = 15; cels <= 35; cels += 1.0)
		{
			Double fahre = (cels * 1.8) + 32;
			out.println("<tr>");
			out.println("<td>" + FMT.format(cels) + "</td>");
			out.println("<td>" + FMT.format(fahre) + "</td>");
			out.println("</tr>");
		}
			out.println(PAGE_BOTTOM);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
