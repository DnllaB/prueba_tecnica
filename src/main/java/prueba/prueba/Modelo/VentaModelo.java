package prueba.prueba.Modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "venta")
public class VentaModelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_venta;
    private LocalDateTime fecha_venta;
    private int cantidad;
    private float 	 precio_unitario;
    private float total;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private ProductoModelo id_producto;

    @ManyToOne
    @JoinColumn(name = "id_vendedor")
    private VentaModelo id_vendedor;
}

