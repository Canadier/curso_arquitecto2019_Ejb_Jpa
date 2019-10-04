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
 * Servlet implementation class ModificarAction
 */
@WebServlet("/ModificarAction")
public class ModificarAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//Inyeccion de dependencia
	@EJB
	DaoPedidos dao;	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idPedido = Integer.parseInt(request.getParameter("id"));
		
		Pedido pedido = dao.getPedido(idPedido);
		
		pedido.setCategoria(request.getParameter("categoria"));
		pedido.setPrecio(Double.parseDouble(request.getParameter("precio")));
		pedido.setProducto(request.getParameter("producto"));
		
		dao.modificarPedido(pedido);
 		
	}

}
