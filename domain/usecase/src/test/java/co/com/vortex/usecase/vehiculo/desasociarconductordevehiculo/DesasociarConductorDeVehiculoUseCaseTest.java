package co.com.vortex.usecase.vehiculo.desasociarconductordevehiculo;

import co.com.vortex.model.conductor.Conductor;
import co.com.vortex.model.vehiculo.Vehiculo;
import co.com.vortex.model.vehiculo.gateways.VehiculoRepository;
import co.com.vortex.usecase.vehiculo.asociarconductoravehiculo.AsociarConductorAVehiculoUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DesasociarConductorDeVehiculoUseCaseTest {

    @Mock
    private VehiculoRepository vehiculoRepository;
    @InjectMocks
    private DesasociarConductorDeVehiculoUseCase desasociarConductorDeVehiculoUseCase  ;
    @Test
    void desasociarConductorAVehiculo() {

        Conductor conductor = Conductor.builder()
                .id(1)
                .identificacion("100037")
                .nombre("Erick")
                .apellido("Diaz")
                .telefono("1234567")
                .direccion("Cra 88C #45A")
                .build();

        Vehiculo vehiculoSinAsociar = Vehiculo.builder()
                .id(2)
                .modelo("2023")
                .placa("AAA-111")
                .capacidad("10kg")
                .build();

        Vehiculo vehiculoConAsociado = Vehiculo.builder()
                .id(2)
                .modelo("2023")
                .placa("AAA-111")
                .capacidad("10kg")
                .conductor(conductor)
                .build();


        when(vehiculoRepository.desasociarConductorDeVehiculo(2,1)).thenReturn(vehiculoSinAsociar);
        Vehiculo result = desasociarConductorDeVehiculoUseCase.desasociarConductorAVehiculo(vehiculoSinAsociar.getId(),conductor.getId());

        assertNotNull(result);
        assertNotEquals(vehiculoConAsociado,result);
        assertEquals(vehiculoSinAsociar,result);
    }
}