package co.com.vortex.jpa.conductor;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Table(name = "conductores")
public class ConductorData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "identificacion", nullable = false)
    @Size(max = 11, message = "Limite máximo de 11 caracteres")
    @Pattern(regexp = "^[^a-zA-Z\\s]*$", message = "El campo solamente debe contener numeros")
    private String identificacion;

    @Column(name = "apellido")
    @Size(max = 20, message = "Limite máximo de 20 caracteres")
    @Pattern(regexp = "[^0-9]*", message = "El campo no debe contener números")
    private String apellido;

    @Column(name = "nombre", nullable = false)
    @Size(max = 20, message = "Limite máximo de 20 caracteres")
    @Pattern(regexp = "[^0-9]*", message = "El campo no debe contener números")
    private String nombre;

    @Column(name = "telefono", nullable = false)
    @Size(max = 10, message = "Limite máximo de 10 caracteres")
    @Pattern(regexp = "^[^a-zA-Z\\s]*$", message = "El campo solamente debe contener numeros")
    private String telefono;

    @Column(name = "direccion")
    @Size(max = 50, message = "Limite máximo de 50 caracteres")
    private String direccion;
}
