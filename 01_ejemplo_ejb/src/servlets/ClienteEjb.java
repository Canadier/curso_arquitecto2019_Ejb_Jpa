package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ejbs.SaludoEjbLocal;

/**
 * Servlet implementation class ClienteEjb
 */
@WebServlet("/ClienteEjb")
public class ClienteEjb extends HttpServlet {
	
	//Inyeccion de dependencia
	@EJB
	SaludoEjbLocal miejb;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String resultado=miejb.getSaludo("profe");
		PrintWriter out = response.getWriter();
		out.println("<h1>"+resultado+"</h1>");
	}

}
