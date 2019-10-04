package daos;

import java.util.List;

import javax.ejb.Local;

import model.Contacto;

@Local
public interface DaoContactos {
	void eliminarContacto(int id);

	List<Contacto> recuperarContactos();

	void altaContacto(Contacto contacto);
	
	List<Contacto> recuperarContactosPorNombre(String n);
	
	Contacto recuperarContactoPorEmail(String email);
}
