package prueba.prueba.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prueba.prueba.Modelo.VendedorModelo;
import prueba.prueba.Modelo.VentaModelo;
import prueba.prueba.Repository.VendedorRepository;
import prueba.prueba.Repository.VentaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class VentaService {
    @Autowired
    private VentaRepository ventaRepository;


    public List<VentaModelo> buscarVentas() throws Exception {
        List<VentaModelo> listaVentas = ventaRepository.findAll();
        if(listaVentas.isEmpty()) {
            throw new Exception("No se encontraron usuarios");
        }
        return listaVentas;
    }
    public Optional<VentaModelo> buscarIdVenta(Integer id){

        Optional<VentaModelo> buscarVenta= ventaRepository.findById(id);
        if (buscarVenta.isPresent())
        {
            System.out.println("Venta no existe");
        }
        return ventaRepository.findById(id);
    }

    public void nuevaVenta(VentaModelo ventaModelo) {

        ventaRepository.save(ventaModelo);
    }

    public VentaModelo editarVenta(Integer id, VentaModelo ventaModelo) throws Exception {
        Optional<VentaModelo> editarVenta = ventaRepository.findById(id);
        if (editarVenta.isPresent()) {
            VentaModelo ventaEditada = editarVenta.get();
            ventaEditada.setId_vendedor(ventaModelo.getId_vendedor());

            return ventaRepository.save(ventaEditada);
        } else {
            throw new Exception("Venta no existe");
        }
    }




}
