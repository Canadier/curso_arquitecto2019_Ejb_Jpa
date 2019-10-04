package daos;

import java.util.List;

import javax.ejb.Local;

import model.Pedido;

@Local
public interface DaoPedidos {
	
	void altaPedido (Pedido pedido);
	
	void modificarPedido (Pedido pedido);
	
	void eliminarPedido (int idPedido);
	
	Pedido getPedido(int idPedido);
	
	List<Pedido> getListaPedidos();
	

}
