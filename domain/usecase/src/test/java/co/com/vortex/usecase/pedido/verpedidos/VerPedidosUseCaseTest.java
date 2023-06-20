package co.com.vortex.usecase.pedido.verpedidos;

import co.com.vortex.model.pedido.Pedido;
import co.com.vortex.model.pedido.gateways.PedidoRepository;
import co.com.vortex.usecase.pedido.crearpedido.CrearPedidoUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class VerPedidosUseCaseTest {

    @Mock
    private PedidoRepository pedidoRepository;
    @InjectMocks
    private VerPedidosUseCase verPedidosUseCase ;
    @Test
    void listarPedidos() {


        Pedido pedido = Pedido.builder()
                .id(1)
                .tipoPedido("Contraentrega")
                .direccion("Cra 88C#45A")
                .build();
        Pedido pedido1 = Pedido.builder()
                .id(2)
                .tipoPedido("Premium")
                .direccion("Cra 30C#88")
                .build();
        List<Pedido> pedidos = List.of(pedido,pedido1);
        when(pedidoRepository.listarPedidos()).thenReturn(pedidos);
        List<Pedido> result = verPedidosUseCase.listarPedidos();

        assertNotNull(result);
        assertEquals(pedidos,result);
    }
}