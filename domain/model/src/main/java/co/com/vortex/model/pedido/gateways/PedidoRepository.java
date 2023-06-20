package co.com.vortex.model.pedido.gateways;

import co.com.vortex.model.pedido.Pedido;

import java.util.List;
import java.util.Optional;

public interface PedidoRepository {

    List<Pedido> listarPedidos();

    Pedido crearPedido( Pedido pedido);

    Pedido findPedidoById(Integer id);

}
