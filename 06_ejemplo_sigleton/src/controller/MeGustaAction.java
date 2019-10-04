package controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ejbs.ContadorEjb;

/**
 * Servlet implementation class MeGustaAction
 */
@WebServlet("/MeGustaAction")
public class MeGustaAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	ContadorEjb contador;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		contador.incrementar();
	}

}
