package co.com.vortex.jpa.converters;

import co.com.vortex.jpa.vehiculo.VehiculoData;

import co.com.vortex.model.vehiculo.Vehiculo;

import java.util.List;

public class ConverterVehiculo {

    private ConverterVehiculo() {
        throw new IllegalStateException("Utility Class");
    }

    public static Vehiculo convertVehiculoDataToVehiculo(VehiculoData vehiculoData) {
        return vehiculoData != null ? Vehiculo.builder()
                .id(vehiculoData.getId())
                .conductor(vehiculoData.getConductor() == null ? null
                        : ConverterConductor.convertConductorDataToConductor(vehiculoData.getConductor()))
                .modelo(vehiculoData.getModelo())
                .capacidad(vehiculoData.getCapacidad())
                .placa(vehiculoData.getPlaca())
                .build()
                : Vehiculo.builder().build();

    }

    public static List<Vehiculo> convertVehiculosDataToVehiculos(List<VehiculoData> vehiculoDataList) {
        return vehiculoDataList.stream().map(ConverterVehiculo::convertVehiculoDataToVehiculo).toList();
    }

    public static VehiculoData convertVehiculoToVehiculoData(Vehiculo vehiculo) {
        VehiculoData vehiculoData = new VehiculoData();
        if (vehiculo != null) {
            vehiculoData.setId(vehiculo.getId());
            vehiculoData.setConductor(vehiculo.getConductor() == null ? null
                    : ConverterConductor.convertConductorToConductorData(vehiculo.getConductor()));
            vehiculoData.setCapacidad(vehiculo.getCapacidad());
            vehiculoData.setModelo(vehiculo.getModelo());
            vehiculoData.setPlaca(vehiculo.getPlaca());
        }
        return vehiculoData;
    }

    public static List<VehiculoData> convertVehiculosToVehiculosData(List<Vehiculo> vehiculos) {
        return vehiculos.stream().map(ConverterVehiculo::convertVehiculoToVehiculoData).toList();
    }
}
