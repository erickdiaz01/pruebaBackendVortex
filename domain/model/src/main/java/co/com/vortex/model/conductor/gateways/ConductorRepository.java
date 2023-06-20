package co.com.vortex.model.conductor.gateways;

import co.com.vortex.model.conductor.Conductor;

import java.util.List;

public interface ConductorRepository {

    Conductor findConductorByIdentificacion(String identificacion);

    List<Conductor> listarConductores();

    Conductor registrarConductor(Conductor conductor);


}
