package prueba.prueba.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import prueba.prueba.Modelo.VendedorModelo;
import prueba.prueba.Service.VendedorService;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping ("v1/Vendedor")
public class VendedorController {
    @Autowired

    private VendedorService vendedorService;



    //Listar los vendedores
    @GetMapping ("/Listar")
    public List<VendedorModelo> listaVendedores() throws Exception {
        return vendedorService.buscarUsuarios();

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findUserById(@PathVariable ("id") Integer id)
    {
      Optional <VendedorModelo>  vendedorModelo = vendedorService.buscarIdVendedor(id);
        return new ResponseEntity<>(vendedorModelo, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> nuevoVendedor(@RequestBody VendedorModelo vendedorModelo) {
        vendedorService.nuevoVendedor(vendedorModelo);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity <?> removeUser(@PathVariable ("id") Integer id) throws Exception
    {
        vendedorService.removeUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }





}
