package prueba.prueba.Modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor

@Table(name = "vendedor")
public class VendedorModelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_vendedor;
    private int cedula_vendedor;
    private String nombre;
    private String apellido;


    public VendedorModelo() {
    }
}
