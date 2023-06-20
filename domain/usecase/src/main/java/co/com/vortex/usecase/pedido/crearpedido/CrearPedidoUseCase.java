package co.com.vortex.usecase.pedido.crearpedido;

import co.com.vortex.model.pedido.Pedido;
import co.com.vortex.model.pedido.gateways.PedidoRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CrearPedidoUseCase {

    private final PedidoRepository pedidoRepository;

    public Pedido crearPedido(Pedido pedido) {
        return pedidoRepository.crearPedido(pedido);
    }
}
