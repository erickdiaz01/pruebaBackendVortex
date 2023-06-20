package co.com.vortex.usecase.conductor.registrarconductores;

import co.com.vortex.model.conductor.Conductor;
import co.com.vortex.model.conductor.gateways.ConductorRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RegistrarConductoresUseCase {
    private final ConductorRepository conductorRepository;

    public Conductor registrarConductor(Conductor conductor) {
        return conductorRepository.registrarConductor(conductor);
    }
}
