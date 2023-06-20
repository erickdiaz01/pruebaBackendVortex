package co.com.vortex.usecase.vehiculo.asociarconductoravehiculo;

import co.com.vortex.model.vehiculo.Vehiculo;
import co.com.vortex.model.vehiculo.gateways.VehiculoRepository;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
public class AsociarConductorAVehiculoUseCase {
    private final VehiculoRepository vehiculoRepository;

    public Vehiculo asociarConductorAVehiculo(int vehiculoId,int conductorId){
        return vehiculoRepository.asociarConductorAVehiculo(vehiculoId,conductorId);
    }
}
