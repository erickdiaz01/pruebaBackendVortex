package co.com.vortex.model.vehiculo.gateways;

import co.com.vortex.model.vehiculo.Vehiculo;

import java.util.List;

public interface VehiculoRepository {
    Vehiculo registrarVehiculo(Vehiculo vehiculo);

    List<Vehiculo> listarVehiculosDisponiblesParaConductor(int conductorId);

    List<Vehiculo> listarVehiculosAsociadosAConductor(int conductorId);

    Vehiculo asociarConductorAVehiculo(int vehiculoId, int conductorId);
Vehiculo desasociarConductorDeVehiculo(int vehiculoId,int conductorId);
}
