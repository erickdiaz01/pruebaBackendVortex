package co.com.vortex.usecase.vehiculo.vervehiculosasociadosaconductor;

import co.com.vortex.model.conductor.Conductor;
import co.com.vortex.model.vehiculo.Vehiculo;
import co.com.vortex.model.vehiculo.gateways.VehiculoRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VerVehiculosAsociadosAConductorUseCaseTest {

    @Mock
    private VehiculoRepository vehiculoRepository;
    @InjectMocks
    private VerVehiculosAsociadosAConductorUseCase verVehiculosAsociadosAConductorUseCase;

    @Test
    void listarVehiculosAsociados() {

        Conductor conductor = Conductor.builder()
                .id(1)
                .identificacion("100037")
                .nombre("Erick")
                .apellido("Diaz")
                .telefono("1234567")
                .direccion("Cra 88C #45A")
                .build();

        Vehiculo vehiculo = Vehiculo.builder()
                .id(1)
                .modelo("2015")
                .placa("BBB-222")
                .capacidad("15kg")
                .build();

        Vehiculo vehiculo1 = Vehiculo.builder()
                .id(2)
                .modelo("2020")
                .placa("CCC-333")
                .capacidad("20kg")
                .conductor(conductor)
                .build();

        Vehiculo vehiculo2 = Vehiculo.builder()
                .id(3)
                .modelo("2023")
                .placa("AAA-111")
                .capacidad("10kg")
                .build();

        List<Vehiculo> vehiculos = List.of(vehiculo, vehiculo1, vehiculo2);
        List<Vehiculo> vehiculosAsociadosAConductor = vehiculos.stream().filter(vehiculoFilter -> {
            if (vehiculoFilter.getConductor() == null) {
                return false;
            } else {
                return vehiculoFilter.getConductor().getId() == 1;
            }
        }).toList();

        when(vehiculoRepository.listarVehiculosAsociadosAConductor(1)).thenReturn(vehiculosAsociadosAConductor);
        List<Vehiculo> result = verVehiculosAsociadosAConductorUseCase.listarVehiculosAsociados(conductor.getId());
        List<Vehiculo> vehiculosAsociados = List.of(vehiculo1);
        assertNotNull(result);
        assertEquals(result, vehiculosAsociados);

    }
}