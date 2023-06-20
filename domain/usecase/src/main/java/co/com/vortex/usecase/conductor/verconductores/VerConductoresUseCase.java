package co.com.vortex.usecase.conductor.verconductores;

import co.com.vortex.model.conductor.Conductor;
import co.com.vortex.model.conductor.gateways.ConductorRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class VerConductoresUseCase {
    private final ConductorRepository conductorRepository;

    public List<Conductor> listarConductores() {
        return conductorRepository.listarConductores();
    }
}
