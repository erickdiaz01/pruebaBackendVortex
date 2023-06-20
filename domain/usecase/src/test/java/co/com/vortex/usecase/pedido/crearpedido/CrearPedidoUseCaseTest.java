package co.com.vortex.usecase.pedido.crearpedido;

import co.com.vortex.model.pedido.Pedido;
import co.com.vortex.model.pedido.gateways.PedidoRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CrearPedidoUseCaseTest {

    @Mock
    private PedidoRepository pedidoRepository;
    @InjectMocks
    private CrearPedidoUseCase crearPedidoUseCase;

    @Test
    void crearPedido() {

        Pedido pedido = Pedido.builder()
                .id(1)
                .tipoPedido("Contraentrega")
                .direccion("Cra 88C#45A")
                .build();
        when(pedidoRepository.crearPedido(pedido)).thenReturn(pedido);
        Pedido result = crearPedidoUseCase.crearPedido(pedido);

        assertNotNull(result);
        assertEquals(pedido, result);
    }
}