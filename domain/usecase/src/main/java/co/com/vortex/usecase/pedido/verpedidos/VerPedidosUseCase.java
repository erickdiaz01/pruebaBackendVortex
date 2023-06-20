package co.com.vortex.usecase.pedido.verpedidos;

import co.com.vortex.model.pedido.Pedido;
import co.com.vortex.model.pedido.gateways.PedidoRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class VerPedidosUseCase {
    private final PedidoRepository pedidoRepository;

    public List<Pedido> listarPedidos() {
        return pedidoRepository.listarPedidos();

    }
}
