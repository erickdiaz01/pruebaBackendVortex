package co.com.vortex.usecase.vehiculo.vervehiculosasociadosaconductor;

import co.com.vortex.model.vehiculo.Vehiculo;
import co.com.vortex.model.vehiculo.gateways.VehiculoRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class VerVehiculosAsociadosAConductorUseCase {

    private  final VehiculoRepository vehiculoRepository;

    public List<Vehiculo> listarVehiculosAsociados(int conductorId){
        return vehiculoRepository.listarVehiculosAsociadosAConductor(conductorId);
    }
}
