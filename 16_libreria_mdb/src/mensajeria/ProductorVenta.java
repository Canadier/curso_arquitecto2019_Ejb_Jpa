package mensajeria;

import javax.ejb.Local;

import model.Venta;

@Local
public interface ProductorVenta {

	void enviarVenta(Venta venta);
}
