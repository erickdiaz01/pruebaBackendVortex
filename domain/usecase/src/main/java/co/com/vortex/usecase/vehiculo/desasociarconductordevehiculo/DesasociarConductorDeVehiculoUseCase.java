package co.com.vortex.usecase.vehiculo.desasociarconductordevehiculo;

import co.com.vortex.model.vehiculo.Vehiculo;
import co.com.vortex.model.vehiculo.gateways.VehiculoRepository;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
public class DesasociarConductorDeVehiculoUseCase {

    private final VehiculoRepository vehiculoRepository;

    public Vehiculo desasociarConductorAVehiculo(int vehiculoId, int conductorId){
        return vehiculoRepository.desasociarConductorDeVehiculo(vehiculoId,conductorId);
    }
}
