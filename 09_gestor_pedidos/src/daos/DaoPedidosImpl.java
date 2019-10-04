package daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Pedido;

/**
 * Session Bean implementation class DaoPedidosImpl
 */
@Stateless
public class DaoPedidosImpl implements DaoPedidos {

	@PersistenceContext(unitName = "almacenPU")
	EntityManager em;
	
	@Override
	public void altaPedido(Pedido pedido) {
		em.persist(pedido);
	}

	@Override
	public void modificarPedido(Pedido pedido) {
		em.merge(pedido);
		
	}

	@Override
	public void eliminarPedido(int idPedido) {
		Pedido pedido = getPedido(idPedido);
		if (pedido!=null) {
			em.remove(pedido);
		}
		
	}

	@Override
	public Pedido getPedido(int idPedido) {
		return em.find(Pedido.class, idPedido);
	}

	@Override
	public List<Pedido> getListaPedidos() {
		String jpql="Select p From Pedido p";
		Query qr = em.createQuery(jpql);
		List<Pedido> resultList = (List<Pedido>)qr.getResultList();
		return resultList;
	}

}
