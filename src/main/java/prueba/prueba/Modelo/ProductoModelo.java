package prueba.prueba.Modelo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;



@Entity
@Data
@AllArgsConstructor
@Table(name = "producto")
public class ProductoModelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_producto;
    private String descripcion;
    private float precio;
    private int stock;
    private String marca;
}


