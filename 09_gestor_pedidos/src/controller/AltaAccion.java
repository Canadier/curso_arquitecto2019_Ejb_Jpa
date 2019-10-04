package controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.DaoPedidos;
import model.Pedido;

/**
 * Servlet implementation class AltaAccion
 */
@WebServlet("/AltaAccion")
public class AltaAccion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//Inyeccion de dependencia
	@EJB
	DaoPedidos dao;	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String categoria = request.getParameter("categoria");
		double precio = Double.parseDouble(request.getParameter("precio"));
		String producto = request.getParameter("producto");
		
		Pedido pedido = new Pedido(categoria,precio,producto);
		dao.altaPedido(pedido);
		
	}

}
