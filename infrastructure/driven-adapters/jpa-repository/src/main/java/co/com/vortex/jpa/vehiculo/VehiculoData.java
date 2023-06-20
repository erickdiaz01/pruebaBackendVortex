package co.com.vortex.jpa.vehiculo;

import co.com.vortex.jpa.conductor.ConductorData;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
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
@Table(name = "vehiculos")
public class VehiculoData {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "modelo",nullable = false)
    @Size(max = 4, message = "Limite máximo de 4 caracteres")
    private String modelo;

    @Column(name = "placa",nullable = false)
    @Size(max = 7, message = "Limite máximo de 7 caracteres")
    private String placa;


    @Column(name = "capacidad")
    @Size(max = 7, message = "Limite máximo de 7 caracteres")
    private  String capacidad;

    @ManyToOne(optional = true)
    @JoinColumn(name = "conductor_id",nullable = true)
    private ConductorData conductor;
}
