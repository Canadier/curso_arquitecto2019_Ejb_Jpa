package mensajeria;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;

import model.Venta;

/**
 * Session Bean implementation class ProductorVentaImpl
 */
@Stateless
public class ProductorVentaImpl implements ProductorVenta {


	@Resource(type=ConnectionFactory.class,lookup="java:/jms/factoryVentasLibros")
	ConnectionFactory factory;
	@Resource(type=Queue.class,lookup="java:/jms/colaVentasLibros")
	Queue cola;

	@Override
	public void enviarVenta(Venta venta) {
		try (Connection cn=factory.createConnection();Session sesion= cn.createSession();){
			
			//creamos productor de mensajes
			MessageProducer productor=sesion.createProducer(cola);
			//creamos el mensaje
			ObjectMessage obj=sesion.createObjectMessage(venta);
			//enviamos mensaje
			productor.send(obj);
			
		}
		catch(JMSException ex){
			ex.printStackTrace();
		}
		
	}

}
