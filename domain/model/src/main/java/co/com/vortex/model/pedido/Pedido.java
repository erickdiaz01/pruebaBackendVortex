package co.com.vortex.model.pedido;

import co.com.vortex.model.conductor.Conductor;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Pedido {

    private int id;
    private String tipoPedido;
    private String direccion;
    private Conductor conductor;
}
