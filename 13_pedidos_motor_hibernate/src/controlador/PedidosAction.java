package controlador;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.DaoPedidos;
import model.Pedido;

/**
 * Servlet implementation class PedidosAction
 */
@WebServlet("/PedidosAction")
public class PedidosAction extends HttpServlet {
	@EJB
	DaoPedidos dao;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Pedido> pedidos=dao.recuperarPedidos();
		request.setAttribute("pedidos", pedidos);
		
	}

}
