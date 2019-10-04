package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ejbs.SaludoEjbLocal;

/**
 * Servlet implementation class ClienteEjb2
 */
@WebServlet("/ClienteEjb2")
public class ClienteEjb2 extends HttpServlet {
	//inyección de dependencia
	@Inject
	SaludoEjbLocal miejb;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String resultado=miejb.getSaludo("profe");
		PrintWriter out=response.getWriter();
		out.println("<h1>"+resultado+"</h1>");
		
	}

}

