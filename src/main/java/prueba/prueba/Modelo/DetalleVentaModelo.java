package prueba.prueba.Modelo;

import jakarta.persistence.JoinColumn;

public class DetalleVentaModelo {


    private int id_detalle_venta;
    private int cantidad;
    private float precio_unitario;
    private float subtotal;

    @JoinColumn
    private int id_venta;
    @JoinColumn
    private int id_producto;
}
