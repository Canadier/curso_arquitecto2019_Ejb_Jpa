package daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Cliente;
@Stateless
public class DaoClientesImpl implements DaoClientes {
	@PersistenceContext(unitName = "librosPU")
	EntityManager em;
	
	@Override
	public boolean autenticar(String user, String pass) {
		String jpql="Select c From Cliente c Where c.usuario=?1 and c.password=?2";
		Query qr=em.createQuery(jpql);
		qr.setParameter(1, user);
		qr.setParameter(2, pass);
		return qr.getResultList().size()>0;
	}

	@Override
	public void registrar(Cliente c) {
		em.persist(c);
	}

	@Override
	public Cliente getCliente(String user, String pass) {
		String jpql="Select c From Cliente c Where c.usuario=?1 and c.password=?2";
		Query qr=em.createQuery(jpql);
		qr.setParameter(1, user);
		qr.setParameter(2, pass);
		List<Cliente> clientes=(List<Cliente>)qr.getResultList();
		return qr.getResultList().size()>0?(Cliente)clientes.get(0):null;
	}
	
	

}
