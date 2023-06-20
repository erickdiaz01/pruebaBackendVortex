package co.com.vortex.model.vehiculo;
import co.com.vortex.model.conductor.Conductor;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Vehiculo {
    private int id;
    private String modelo;
    private String placa;
    private  String capacidad;
    private Conductor conductor;
}
