package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;

import beans.Producto;

/**
 * Session Bean implementation class CarritoEjbImpl
 */
@Stateful
public class CarritoEjbImpl implements CarritoEjb {
	List<Producto> carrito;
	//cuando la instancia es asociada a un cliente
	@PostConstruct
	public void init() {
		carrito=new ArrayList<>();
	}
	@Override
	public void agregar(Producto p) {
		carrito.add(p);		
	}
	@Override
	public void eliminar(int pos) {
		carrito.remove(pos);		
	}
	@Override
	public List<Producto> recuperarCarrito() {
		return carrito;
	}

	

}
