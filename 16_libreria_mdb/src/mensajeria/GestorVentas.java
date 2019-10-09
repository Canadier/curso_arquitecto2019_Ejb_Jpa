package mensajeria;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import daos.DaoVentas;
import model.Venta;

/**
 * Message-Driven Bean implementation class for: ProcesaVenta
 */
@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
					@ActivationConfigProperty(
				propertyName = "destinationLookup", propertyValue = "java:/jms/colaVentasLibros")
		})
public class GestorVentas implements MessageListener {

    
	@EJB
	DaoVentas dao;
    public void onMessage(Message message) {
    	ObjectMessage obj = (ObjectMessage)message;
        try {
     	   Venta venta=(Venta)obj.getObject();
     	   dao.registarVenta(venta);
     	  System.out.println("Venta del libro : "+venta.getLibro().getTitulo()+" realizada");
        } catch (JMSException e) {
        	// TODO Auto-generated catch block
        	e.printStackTrace();
        }
    	
        
    }

}
