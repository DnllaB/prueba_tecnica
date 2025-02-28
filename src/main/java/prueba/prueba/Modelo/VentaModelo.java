package prueba.prueba.Modelo;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import java.time.LocalDateTime;

public class VentaModelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_venta;
    private LocalDateTime fecha_venta;
    private float total;

    @JoinColumn
    private int id_usuario;

    @JoinColumn
    private int id_cliente;
}
