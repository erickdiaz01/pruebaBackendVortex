package co.com.vortex.api;

import co.com.vortex.api.responsehandler.ResponseHandler;

import co.com.vortex.model.pedido.Pedido;

import co.com.vortex.usecase.pedido.crearpedido.CrearPedidoUseCase;
import co.com.vortex.usecase.pedido.verpedidos.VerPedidosUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/pedido", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class PedidoRest {

    private final CrearPedidoUseCase crearPedidoUseCase;
    private final VerPedidosUseCase verPedidosUseCase;

    @GetMapping
    public ResponseEntity<List<Pedido>> getPedidos() {
        try {
            return ResponseHandler.generateResponse(verPedidosUseCase.listarPedidos(), HttpStatus.OK);
        } catch (Exception error) {
            throw new RuntimeException("No fue posible listar los pedidos", error);
        }
    }

    @PostMapping
    public ResponseEntity<Pedido> crearPedido(@RequestBody Pedido pedido) {
        try {
            return ResponseHandler.generateResponse(crearPedidoUseCase.crearPedido(pedido), HttpStatus.OK);
        } catch (Exception error) {
            throw new RuntimeException("No fue posible crear el pedido", error);
        }
    }
}
