package controlador;

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
		String url="opciones.html";
		String op=request.getParameter("op");
		switch(op) {			
			case "doAlta":
				request.getRequestDispatcher("AltaAction").include(request, response);
				break;
			case "doEliminar":
				request.getRequestDispatcher("EliminarAction").include(request, response);
				url="pedidos.jsp";
				break;
			case "doPedidos":				
				request.getRequestDispatcher("PedidosAction").include(request, response);
				url="pedidos.jsp";
				break;
			case "doRecuperar":
				request.getRequestDispatcher("RecuperarPedidoAction").include(request, response);
				url="editar.jsp";
				break;
			case "doModificar":
				request.getRequestDispatcher("ModificarAction").include(request, response);
				url="pedidos.jsp";
				break;
			case "toFormulario":
				url="formulario.html";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
