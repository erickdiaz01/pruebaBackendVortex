package co.com.vortex.usecase.vehiculo.asociarconductoravehiculo;

import co.com.vortex.model.conductor.Conductor;
import co.com.vortex.model.vehiculo.Vehiculo;
import co.com.vortex.model.vehiculo.gateways.VehiculoRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AsociarConductorAVehiculoUseCaseTest {

        @Mock
        private VehiculoRepository vehiculoRepository;
        @InjectMocks
        private AsociarConductorAVehiculoUseCase asociarConductorAVehiculoUseCase;

        @Test
        void asociarConductorAVehiculo() {

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

                when(vehiculoRepository.asociarConductorAVehiculo(2, 1)).thenReturn(vehiculoConAsociado);
                Vehiculo result = asociarConductorAVehiculoUseCase.asociarConductorAVehiculo(vehiculoSinAsociar.getId(),
                                conductor.getId());

                assertNotNull(result);
                assertEquals(vehiculoConAsociado, result);
                assertNotEquals(vehiculoSinAsociar, result);
        }
}