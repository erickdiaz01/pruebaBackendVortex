package co.com.vortex.jpa.pedido;

import co.com.vortex.jpa.conductor.ConductorData;

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
@Table(name = "pedidos")
public class PedidoData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "tipo_pedido")
    @Size(max = 20, message = "Limite máximo de 20 caracteres")
    @Pattern(regexp = "[^0-9]*", message = "El campo no debe contener números")
    private String tipoPedido;

    @Column(name = "direccion",nullable = false)
    @Size(max = 50, message = "Limite máximo de 50 caracteres")
    private String direccion;

    @ManyToOne(optional = true)
    @JoinColumn(name = "conductor_id",nullable = true)
    private ConductorData conductor;

}
