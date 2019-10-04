package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String urlFinal = "entrada.html";
		String op = request.getParameter("op");

		switch (op) {
		
		case "doAlta":
			request.getRequestDispatcher("AltaAction").include(request, response);
			urlFinal = "entrada.html";
			break;

		case "doPedidos":
			request.getRequestDispatcher("PedidosAction").include(request, response);
			urlFinal="pedidos.jsp";
			break;

			
		case "doEliminar":
			request.getRequestDispatcher("EliminarAction").include(request, response);
			urlFinal="pedidos.jsp";
			break;
			
		case "doEditar":
			request.getRequestDispatcher("EditarAction").include(request, response);
			urlFinal = "editar.jsp";
			break;
			
		case "doModificar":
			request.getRequestDispatcher("ModificarAction").include(request, response);
			urlFinal="pedidos.jsp";
			break;

		case "toAlta":
			urlFinal = "altapedido.html";
			break;

		case "toEntrada":
			urlFinal = "entrada.html";
			break;
		}

		// transferimos la petición a la vista
		request.getRequestDispatcher(urlFinal).forward(request, response);
		
	}
	
}
