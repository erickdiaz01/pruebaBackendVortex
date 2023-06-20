package co.com.vortex.jpa.converters;

import co.com.vortex.jpa.conductor.ConductorData;
import co.com.vortex.model.conductor.Conductor;

import java.util.List;

public class ConverterConductor {

    private ConverterConductor() {
        throw new IllegalStateException("Utility Class");
    }


    public static Conductor convertConductorDataToConductor(ConductorData conductorData) {
        return conductorData != null ? Conductor.builder()
                .id(conductorData.getId())
                .identificacion(conductorData.getIdentificacion())
                .apellido(conductorData.getApellido() !=null? conductorData.getApellido() : "")
                .nombre(conductorData.getNombre())
                .direccion(conductorData.getDireccion() != null ? conductorData.getDireccion() : "")
                .telefono(conductorData.getTelefono())
                .build()
                : Conductor.builder().build();

    }

    public static List<Conductor> convertCondutoresDataToConductores(List<ConductorData> conductorDataList) {
        return conductorDataList.stream().map(ConverterConductor::convertConductorDataToConductor).toList();
    }

    public static ConductorData convertConductorToConductorData(Conductor conductor) {
        ConductorData conductorData = new ConductorData();
        if (conductor != null) {
          conductorData.setId(conductor.getId());
          conductorData.setIdentificacion(conductor.getIdentificacion());
          conductorData.setApellido(conductor.getApellido()!=null ? conductor.getApellido() : "");
          conductorData.setNombre(conductor.getNombre());
          conductorData.setDireccion(conductor.getDireccion()!= null ? conductor.getDireccion() : "");
          conductorData.setTelefono(conductor.getTelefono());
        }
        return conductorData;
    }

    public static List<ConductorData> convertCondutoresToConductoresData(List<Conductor> conductores) {
        return conductores.stream().map(ConverterConductor::convertConductorToConductorData).toList();
    }

}
