package prueba.prueba.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import prueba.prueba.Modelo.VentaModelo;
import prueba.prueba.Service.VentaService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("v1/Venta")
public class VentaController {
    @Autowired
    private VentaService ventaService;

    //Listar los vendedores
    @GetMapping("/Listar")
    public List<VentaModelo> listaVendedores() throws Exception {
        return ventaService.buscarVentas();

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarIdVenta(@PathVariable("id") Integer id)
    {
        Optional<VentaModelo> ventaModelo = ventaService.buscarIdVenta(id);
        return new ResponseEntity<>(ventaModelo, HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> nuevaVenta(@RequestBody VentaModelo ventaModelo) {
        ventaService.nuevaVenta(ventaModelo);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> editarVenta(@PathVariable Integer id, @RequestBody VentaModelo ventaModelo) throws Exception {
        ventaService.editarVenta(id,ventaModelo);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
