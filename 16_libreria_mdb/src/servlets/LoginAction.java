package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daos.DaoClientes;
import daos.DaoTemas;
import model.Cliente;



@WebServlet("/LoginAction")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 2045441377194382792L;
	@EJB
	DaoClientes gestion;
	@EJB
	DaoTemas gtemas;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		boolean resultado=false;
		
		Cliente cliente = gestion.getCliente(request.getParameter("user"),request.getParameter("pwd"));
		if(cliente != null){
			HttpSession sesion = request.getSession();
			sesion.setAttribute("cliente", cliente);
			
			request.setAttribute("temas", gtemas.obtenerTemas());
            resultado=true;
		}
		else{
			request.setAttribute("mensaje", "Usuario no registrado");
		}
       
        request.setAttribute("resultado",resultado);
	}
	

}
