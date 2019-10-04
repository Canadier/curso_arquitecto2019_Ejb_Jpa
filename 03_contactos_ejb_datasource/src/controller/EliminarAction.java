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

@WebServlet("/EliminarAction")
public class EliminarAction extends HttpServlet {

	//Inyeccion de dependencia
	@EJB
	DaoContactos dao;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		int id= Integer.parseInt(request.getParameter("id"));
				
		dao.eliminarContacto(id);
		
	}

}
