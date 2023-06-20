package co.com.vortex.usecase.conductor.registrarconductores;

import co.com.vortex.model.conductor.Conductor;
import co.com.vortex.model.conductor.gateways.ConductorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RegistrarConductoresUseCaseTest {
    @Mock
    private ConductorRepository conductorRepository;

    @InjectMocks
    private RegistrarConductoresUseCase registrarConductoresUseCase;

    @Test
    void registrarConductor() {

        Conductor conductor = Conductor.builder()
                .identificacion("1000375867")
                .nombre("Erick")
                .apellido("Diaz")
                .telefono("1234567")
                .direccion("Cra 88C #45A")
                .build();

        when(conductorRepository.registrarConductor(conductor)).thenReturn(conductor);

        Conductor result = registrarConductoresUseCase.registrarConductor(conductor);

        assertNotNull(result);
        assertEquals(conductor, result);
    }
}