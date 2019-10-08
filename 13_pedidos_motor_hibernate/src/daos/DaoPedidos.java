package daos;

import java.util.List;

import javax.ejb.Local;

import model.Pedido;

@Local
public interface DaoPedidos {
	void altaPedido(Pedido pedido);
	List<Pedido> recuperarPedidos();
	void eliminarPedido(int idPedido);
	Pedido recuperarPedidoPorId(int id);
	void actualizarPedido(Pedido pedido);
}
