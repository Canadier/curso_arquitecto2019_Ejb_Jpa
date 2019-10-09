package servlets;

import java.io.IOException;

import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pedido;

/**
 * Servlet implementation class ProductorPedidos
 */
@WebServlet("/ProductorPedidos")
public class ProductorPedidos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(type=ConnectionFactory.class,lookup="java:/jms/factorytest")
	ConnectionFactory factory;
	@Resource(type=Queue.class,lookup="java:/jms/colatest")
	Queue cola;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Pedido pedido = new Pedido("jamón", 190,"jamón serrano");
		try (Connection cn=factory.createConnection();Session sesion= cn.createSession();){
			
			//creamos productor de mensajes
			MessageProducer productor=sesion.createProducer(cola);
			//creamos el mensaje
			ObjectMessage obj=sesion.createObjectMessage(pedido);
			//enviamos mensaje
			productor.send(obj);
			
		}
		catch(JMSException ex){
			ex.printStackTrace();
		}
	}

}
