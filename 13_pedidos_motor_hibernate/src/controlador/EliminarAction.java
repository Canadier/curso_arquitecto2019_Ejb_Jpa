package controlador;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.DaoPedidos;

/**
 * Servlet implementation class EliminarPedido
 */
@WebServlet("/EliminarAction")
public class EliminarAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	DaoPedidos dao;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		dao.eliminarPedido(Integer.parseInt(request.getParameter("idPedido")));
		request.getRequestDispatcher("PedidosAction").include(request, response);
	}

}
