package co.com.vortex.usecase.conductor.verconductores;

import co.com.vortex.model.conductor.Conductor;
import co.com.vortex.model.conductor.gateways.ConductorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VerConductoresUseCaseTest {

    @Mock
    private ConductorRepository conductorRepository;

    @InjectMocks
    private VerConductoresUseCase verConductoresUseCase;

    @Test
    void listarConductores() {

        Conductor conductor = Conductor.builder()
                .identificacion("100037")
                .nombre("Erick")
                .apellido("Diaz")
                .telefono("1234567")
                .direccion("Cra 88C #45A")
                .build();
        Conductor conductor1 = Conductor.builder()
                .identificacion("123456")
                .nombre("Santiago")
                .apellido("Bueno")
                .telefono("7654321")
                .direccion("Cra 88C #45A")
                .build();
        List<Conductor> conductores = List.of(conductor1, conductor);
        when(conductorRepository.listarConductores()).thenReturn(conductores);

        List<Conductor> result = verConductoresUseCase.listarConductores();

        assertNotNull(result);
        assertEquals(conductores, result);
    }
}