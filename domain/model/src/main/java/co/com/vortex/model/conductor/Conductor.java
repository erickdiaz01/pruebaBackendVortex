package co.com.vortex.model.conductor;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Conductor {

    private int id;
    private String identificacion;
    private String apellido;
    private  String nombre;
    private String telefono;
    private String direccion;
}
