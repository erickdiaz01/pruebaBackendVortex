package co.com.vortex.usecase.vehiculo.registrarvehiculoparapedidos;

import co.com.vortex.model.pedido.Pedido;
import co.com.vortex.model.pedido.gateways.PedidoRepository;
import co.com.vortex.model.vehiculo.Vehiculo;
import co.com.vortex.model.vehiculo.gateways.VehiculoRepository;
import co.com.vortex.usecase.pedido.crearpedido.CrearPedidoUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RegistrarVehiculoParaPedidosUseCaseTest {

    @Mock
    private VehiculoRepository vehiculoRepository;
    @InjectMocks
    private RegistrarVehiculoParaPedidosUseCase registrarVehiculoParaPedidosUseCase ;
    @Test
    void registraVehiculo() {


        Vehiculo vehiculo = Vehiculo.builder()
                .id(1)
                .modelo("2023")
                .placa("AAA-111")
                .capacidad("10kg")
                .build();


        when(vehiculoRepository.registrarVehiculo(vehiculo)).thenReturn(vehiculo);
        Vehiculo result = registrarVehiculoParaPedidosUseCase.registraVehiculo(vehiculo);

        assertNotNull(result);
        assertEquals(vehiculo,result);
    }
}