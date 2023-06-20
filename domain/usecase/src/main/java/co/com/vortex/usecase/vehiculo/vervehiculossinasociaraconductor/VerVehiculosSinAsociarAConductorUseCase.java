package co.com.vortex.usecase.vehiculo.vervehiculossinasociaraconductor;

import co.com.vortex.model.vehiculo.Vehiculo;
import co.com.vortex.model.vehiculo.gateways.VehiculoRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class VerVehiculosSinAsociarAConductorUseCase {

    private final VehiculoRepository vehiculoRepository;

    public List<Vehiculo> listarVehiculosSinAsociar(int conductorId) {
        return vehiculoRepository.listarVehiculosDisponiblesParaConductor(conductorId);
    }
}
