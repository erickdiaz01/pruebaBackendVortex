package co.com.vortex.usecase.vehiculo.registrarvehiculoparapedidos;

import co.com.vortex.model.vehiculo.Vehiculo;
import co.com.vortex.model.vehiculo.gateways.VehiculoRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RegistrarVehiculoParaPedidosUseCase {
    private final VehiculoRepository vehiculoRepository;

    public Vehiculo registraVehiculo(Vehiculo vehiculo) {
        return vehiculoRepository.registrarVehiculo(vehiculo);
    }
}
