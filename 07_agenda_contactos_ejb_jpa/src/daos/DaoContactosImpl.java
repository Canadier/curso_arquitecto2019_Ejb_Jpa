package daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Contacto;

/**
 * Session Bean implementation class DaoContactosImpl
 */
@Stateless
public class DaoContactosImpl implements DaoContactos {

	@PersistenceContext(unitName = "agendaPU")
	EntityManager em;
	
	@Override
	public void eliminarContacto(int id) {
		Contacto contacto = em.find(Contacto.class, id);
		if(contacto!=null) {
			em.remove(contacto);
		}
	}

	@Override
	public List<Contacto> recuperarContactos() {
		String jpql="Select c From Contacto c";
		Query qr = em.createQuery(jpql);
		return (List<Contacto>)qr.getResultList();
	}

	@Override
	public void altaContacto(Contacto contacto) {
		em.persist(contacto);
			
	}

	@Override
	public List<Contacto> recuperarContactosPorNombre(String n) {
		//String jpql="Select c From Contacto c Where c.nombre LIKE '%"+n+"%'";
		String jpql="Select c From Contacto c Where c.nombre LIKE ?1";
		Query qr = em.createQuery(jpql);
		qr.setParameter(1,"%"+n+"%");
		return (List<Contacto>)qr.getResultList();

	}

	@Override
	public Contacto recuperarContactoPorEmail(String email) {
		//String jpql="Select c From Contacto c Where c.email='"+email+"'";
		String jpql="Select c From Contacto c Where c.email=?1";
		Query qr = em.createQuery(jpql);
		qr.setParameter(1,email);
		return (Contacto)qr.getSingleResult();
		
	}

    
    }

