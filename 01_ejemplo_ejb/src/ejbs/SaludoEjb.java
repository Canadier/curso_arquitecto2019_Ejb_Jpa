package ejbs;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class SaludoEjb
 */
@Stateless
public class SaludoEjb implements SaludoEjbLocal {

	@Override
	public String getSaludo(String nombre) {
		return "Bienvenido a mi EJB "+nombre;
	}

}
