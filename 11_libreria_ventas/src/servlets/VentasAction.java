package servlets;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.DaoVentas;
import model.Cliente;
import model.Venta;

/**
 * Servlet implementation class VentasAction
 */
@WebServlet("/VentasAction")
public class VentasAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	DaoVentas dao;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cliente cliente = (Cliente)request.getSession().getAttribute("cliente");
		if (cliente!=null){
			List<Venta> listVentas = dao.getVentasCliente(cliente.getIdCliente());
			request.setAttribute("ventas", listVentas);
		}
	}

}
