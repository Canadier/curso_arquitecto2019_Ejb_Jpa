package daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Cliente;
import model.Venta;

@Stateless
public class DaoVentasImpl implements DaoVentas {

	@PersistenceContext(unitName = "librosPU")
	EntityManager em;
	
	@Override
	public List<Venta> getVentasCliente(int idCliente) {
		/*
		 * String jpql="Select v From Ventas Where v.cliente.idCliente=?1"; // Query
		 * qr=em.createNamedQuery(jpql); // qr.setParameter(1, idCliente); // return
		 * (List<Venta>)qr.getResultList();
		 */		
		Cliente cliente=em.find(Cliente.class, idCliente);
		return cliente.getVentas();
	}

}
