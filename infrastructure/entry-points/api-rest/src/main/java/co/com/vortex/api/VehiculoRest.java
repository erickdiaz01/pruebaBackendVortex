package co.com.vortex.api;

import co.com.vortex.api.responsehandler.ResponseHandler;
import co.com.vortex.model.vehiculo.Vehiculo;
import co.com.vortex.usecase.vehiculo.asociarconductoravehiculo.AsociarConductorAVehiculoUseCase;
import co.com.vortex.usecase.vehiculo.desasociarconductordevehiculo.DesasociarConductorDeVehiculoUseCase;
import co.com.vortex.usecase.vehiculo.registrarvehiculoparapedidos.RegistrarVehiculoParaPedidosUseCase;
import co.com.vortex.usecase.vehiculo.vervehiculosasociadosaconductor.VerVehiculosAsociadosAConductorUseCase;
import co.com.vortex.usecase.vehiculo.vervehiculossinasociaraconductor.VerVehiculosSinAsociarAConductorUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/vehiculo", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class VehiculoRest {
    private final RegistrarVehiculoParaPedidosUseCase registrarVehiculoParaPedidosUseCase;
    private final VerVehiculosAsociadosAConductorUseCase verVehiculosAsociadosAConductorUseCase;
    private final VerVehiculosSinAsociarAConductorUseCase verVehiculosSinAsociarAConductorUseCase;
    private final AsociarConductorAVehiculoUseCase asociarConductorAVehiculoUseCase;
    private final DesasociarConductorDeVehiculoUseCase desasociarConductorDeVehiculoUseCase;

    @PostMapping
    public ResponseEntity<Vehiculo> registrarVehiculo(@RequestBody Vehiculo vehiculo) {
        try {
            return ResponseHandler.generateResponse(registrarVehiculoParaPedidosUseCase.registraVehiculo(vehiculo),
                    HttpStatus.OK);
        } catch (Exception error) {
            throw new RuntimeException("No fue posible registrar el vehiculo", error);
        }

    }

    @GetMapping(path = "/asociados/conductor/{idConductor}")
    public ResponseEntity<List<Vehiculo>> vehiculosAsociadosAlConductor(@PathVariable int idConductor) {
        try {
            return ResponseHandler.generateResponse(
                    verVehiculosAsociadosAConductorUseCase.listarVehiculosAsociados(idConductor), HttpStatus.OK);

        } catch (Exception error) {
            throw new RuntimeException("No fue posible listar los vehiculos", error);
        }
    }

    @GetMapping(path = "/noasociados/conductor/{idConductor}")
    public ResponseEntity<List<Vehiculo>> vehiculosNoAsociadosAlConductor(@PathVariable int idConductor) {
        try {
            return ResponseHandler.generateResponse(
                    verVehiculosSinAsociarAConductorUseCase.listarVehiculosSinAsociar(idConductor), HttpStatus.OK);

        } catch (Exception error) {
            throw new RuntimeException("No fue posible listar los vehiculos disponibles para asociar al conductor",
                    error);
        }
    }

    @PostMapping(path = "/asociar/vehiculo/{idVehiculo}/conductor/{idConductor}")
    public ResponseEntity<Vehiculo> asociarConductorAVehiculo(@PathVariable int idVehiculo,
            @PathVariable int idConductor) {
        try {
            return ResponseHandler.generateResponse(
                    asociarConductorAVehiculoUseCase.asociarConductorAVehiculo(idVehiculo, idConductor), HttpStatus.OK);
        } catch (Exception error) {
            throw new RuntimeException("No fue posible asociar el conductor al vehiculo", error);
        }
    }

    @DeleteMapping(path = "/desasociar/vehiculo/{idVehiculo}/conductor/{idConductor}")
    public ResponseEntity<Vehiculo> desasociarConductorDeVehiculo(@PathVariable int idVehiculo,
            @PathVariable int idConductor) {
        try {
            return ResponseHandler.generateResponse(
                    desasociarConductorDeVehiculoUseCase.desasociarConductorAVehiculo(idVehiculo, idConductor),
                    HttpStatus.OK);

        } catch (Exception error) {
            throw new RuntimeException("No fue posible desasociar el conductor del vehiculo", error);
        }
    }

}
