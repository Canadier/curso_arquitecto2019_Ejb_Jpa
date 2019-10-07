package daos;

import java.util.List;

import javax.ejb.Local;

import model.Venta;

@Local
public interface DaoVentas {

	List<Venta> getVentasCliente(int idCliente);
}
