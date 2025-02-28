package prueba.prueba.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import prueba.prueba.Modelo.ProductoModelo;
import prueba.prueba.Modelo.VendedorModelo;
import prueba.prueba.Modelo.VentaModelo;
import prueba.prueba.Service.ProductoService;

import java.util.List;
import java.util.Optional;

@RestController

@RequestMapping("v1/Producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    //Listar los vendedores
    @GetMapping("/Listar")
    public List<ProductoModelo> listaProducto() throws Exception {
        return productoService.buscarProductos();

    }
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable("id") Integer id)
    {
        Optional<ProductoModelo> productoModelo = productoService.buscarIdProducto(id);
        return new ResponseEntity<>(productoModelo, HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> nuevoProducto(@RequestBody ProductoModelo productoModelo) {
        productoService.nuevoProducto(productoModelo);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @PatchMapping("/{id}")
    public ResponseEntity<?> editarProducto(@PathVariable Integer id, @RequestBody ProductoModelo productoModelo) throws Exception {
        productoService.editarProducto(id,productoModelo);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity <?> eliminarProducto(@PathVariable ("id") Integer id) throws Exception
    {
        productoService.eliminarProducto(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
