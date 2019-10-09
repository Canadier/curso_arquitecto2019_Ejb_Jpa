package daos;

import java.util.List;

import javax.ejb.Local;

import model.Venta;

@Local
public interface DaoVentas {

	void registarVenta (Venta venta);
	List<Venta> getVentasCliente(int idCliente);
}
