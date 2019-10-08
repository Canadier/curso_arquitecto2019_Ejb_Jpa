package controlador;

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
 * Servlet implementation class AltaPedidos
 */
@WebServlet("/AltaAction")
public class AltaAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	DaoPedidos dao;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Pedido pedido=new Pedido(0,request.getParameter("categoria"), 
				Double.parseDouble(request.getParameter("precio")), 
				request.getParameter("producto"));
		dao.altaPedido(pedido);
		
	}

}
