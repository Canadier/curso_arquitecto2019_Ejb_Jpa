package controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.DaoContactos;
import model.Contacto;

/**
 * Servlet implementation class AltaAction
 */
@WebServlet(urlPatterns = {"/AltaAction"})
public class AltaAction extends HttpServlet {
	
	//Inyeccion de dependencia
	@EJB
	DaoContactos dao;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nombre = request.getParameter("nombre");
		String email = request.getParameter("email");
		int edad= Integer.parseInt(request.getParameter("edad"));
		
		Contacto contacto = new Contacto(0,edad,email,nombre);
		
		dao.altaContacto(contacto);
		
	}

}
