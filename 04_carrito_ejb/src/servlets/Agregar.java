package servlets;

import java.io.IOException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Producto;
import modelo.CarritoEjb;

/**
 * Servlet implementation class Agregar
 */
@WebServlet("/Agregar")
public class Agregar extends HttpServlet {

	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Producto p=new Producto(request.getParameter("nombre"), 
				Double.parseDouble(request.getParameter("precio")), 
				Integer.parseInt(request.getParameter("unidades")));
		
		
		HttpSession sesion=request.getSession();
		
		CarritoEjb carritoEjb = (CarritoEjb)sesion.getAttribute("ejb");
		if(carritoEjb==null) {
			carritoEjb=findEjb();
			sesion.setAttribute("ejb", carritoEjb);
		}
		
		carritoEjb.agregar(p);
		
		request.getRequestDispatcher("nuevo.html").forward(request, response);
		
	}
	
	private CarritoEjb findEjb() {
		CarritoEjb miejb=null;
		try {
			Context ct=new InitialContext();
			miejb=(CarritoEjb)ct.lookup("java:global/04_carrito_ejb/CarritoEjbImpl!modelo.CarritoEjb");
			
		}catch(NamingException ex) {
			ex.printStackTrace();
		}
		return miejb;
	}

}
