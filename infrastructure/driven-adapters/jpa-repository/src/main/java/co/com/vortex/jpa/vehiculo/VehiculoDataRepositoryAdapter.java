package co.com.vortex.jpa.vehiculo;

import co.com.vortex.jpa.conductor.ConductorData;
import co.com.vortex.jpa.conductor.ConductorDataRepository;
import co.com.vortex.jpa.converters.ConverterVehiculo;
import co.com.vortex.jpa.exception.UseCaseException;
import co.com.vortex.jpa.helper.AdapterOperations;

import co.com.vortex.model.vehiculo.Vehiculo;
import co.com.vortex.model.vehiculo.gateways.VehiculoRepository;
import org.hibernate.query.IllegalQueryOperationException;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

import static co.com.vortex.jpa.converters.ConverterVehiculo.convertVehiculoDataToVehiculo;
import static co.com.vortex.jpa.converters.ConverterVehiculo.convertVehiculoToVehiculoData;

@Repository
public class VehiculoDataRepositoryAdapter
        extends AdapterOperations<Vehiculo, VehiculoData, Integer, VehiculoDataRepository>
        implements VehiculoRepository {

    private final ConductorDataRepository conductorDataRepository;

    public VehiculoDataRepositoryAdapter(VehiculoDataRepository repository, ObjectMapper mapper,
            ConductorDataRepository conductorDataRepository) {

        super(repository, mapper, d -> mapper.map(d, Vehiculo.class));

        this.conductorDataRepository = conductorDataRepository;
    }

    @Override
    public Vehiculo registrarVehiculo(Vehiculo vehiculo) {
        try {
            VehiculoData vehiculoData = convertVehiculoToVehiculoData(vehiculo);
            return convertVehiculoDataToVehiculo(repository.save(vehiculoData));
        } catch (Exception error) {
            throw new UseCaseException("No fue posible registrar el vehiculo", error);
        }
    }

    @Override
    public List<Vehiculo> listarVehiculosDisponiblesParaConductor(int conductorId) {
        try {
            List<VehiculoData> vehiculos = (List<VehiculoData>) repository.findAll();
            return vehiculos.stream().filter(vehiculoData -> {
                if (vehiculoData.getConductor() == null) {
                    return true;
                } else {
                    return vehiculoData.getConductor().getId() != conductorId;
                }
            }).map(ConverterVehiculo::convertVehiculoDataToVehiculo).toList();
        } catch (Exception error) {
            throw new UseCaseException("No fue posible listar los vehiculos disponibles para el conductor", error);
        }

    }

    @Override
    public List<Vehiculo> listarVehiculosAsociadosAConductor(int conductorId) {
        try {
            List<VehiculoData> vehiculos = (List<VehiculoData>) repository.findAll();
            return vehiculos.stream().filter(vehiculoData -> {
                if (vehiculoData.getConductor() == null) {
                    return false;
                } else {
                    return vehiculoData.getConductor().getId() == conductorId;
                }
            }).map(ConverterVehiculo::convertVehiculoDataToVehiculo).toList();
        } catch (Exception error) {
            throw new UseCaseException("No fue posible listar los vehiculos asociados al conductor", error);
        }

    }

    @Override
    public Vehiculo asociarConductorAVehiculo(int vehiculoId, int conductorId) {
        try {
            VehiculoData vehiculo = repository.findById(vehiculoId).orElseThrow(
                    () -> new IllegalQueryOperationException("No fue posible encontrar el vehiculo a asociar"));
            ConductorData conductor = conductorDataRepository.findById(conductorId).orElseThrow(
                    () -> new IllegalQueryOperationException("No fue posible encontrar el conductor a asociar"));
            if (vehiculo.getConductor() == null) {
                vehiculo.setConductor(conductor);
            } else if (vehiculo.getConductor().getId() != conductorId) {
                vehiculo.setConductor(conductor);
            } else {
                throw new IllegalArgumentException("El vehiculo ya fue asignado al conductor");
            }
            return convertVehiculoDataToVehiculo(repository.save(vehiculo));
        } catch (Exception error) {
            throw new UseCaseException("No fue posible asociar el conductor a un vehiculo", error);
        }
    }

    @Override
    public Vehiculo desasociarConductorDeVehiculo(int vehiculoId, int conductorId) {
        try {
            VehiculoData vehiculo = repository.findById(vehiculoId).orElseThrow(
                    () -> new IllegalQueryOperationException("No fue posible encontrar el vehiculo a asociar"));
            ConductorData conductor = conductorDataRepository.findById(conductorId).orElseThrow(
                    () -> new IllegalQueryOperationException("No fue posible encontrar el conductor a asociar"));
            if (vehiculo.getConductor().getId() == conductorId && conductor != null) {
                vehiculo.setConductor(null);
            } else {
                throw new IllegalArgumentException("El vehiculo no está asociado al conductor");
            }
            return convertVehiculoDataToVehiculo(repository.save(vehiculo));
        } catch (Exception error) {
            throw new UseCaseException("No fue posible desasociar el conductor del vehiculo", error);
        }
    }
}
