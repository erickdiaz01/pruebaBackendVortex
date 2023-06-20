package co.com.vortex.api;


import co.com.vortex.api.responsehandler.ResponseHandler;
import co.com.vortex.model.conductor.Conductor;
import co.com.vortex.usecase.conductor.registrarconductores.RegistrarConductoresUseCase;
import co.com.vortex.usecase.conductor.verconductores.VerConductoresUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/conductor", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ConductorRest {

       private final RegistrarConductoresUseCase registrarConductoresUseCase;
private final VerConductoresUseCase verConductoresUseCase;

    @GetMapping
    public ResponseEntity<List<Conductor>> getConductores() {
     try {
         return ResponseHandler.generateResponse( verConductoresUseCase.listarConductores(), HttpStatus.OK);
     }catch (Exception error){
         throw new RuntimeException("No se encontraron los conductores",error);
     }

    }

    @PostMapping
    public ResponseEntity<Conductor> registrarConductor(@RequestBody Conductor conductor) {
       try {
           return ResponseHandler.generateResponse(registrarConductoresUseCase.registrarConductor(conductor),HttpStatus.OK);
       } catch (Exception error){
           throw new RuntimeException("No se registro el conductor",error);
       }
    }
}
