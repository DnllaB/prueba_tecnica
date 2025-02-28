package prueba.prueba.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prueba.prueba.Modelo.VendedorModelo;
import prueba.prueba.Repository.VendedorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class VendedorService {

    @Autowired
    private VendedorRepository vendedorRepository;


    public List<VendedorModelo> buscarUsuarios() throws Exception {
        List<VendedorModelo> listaUsuarios = vendedorRepository.findAll();
        if(listaUsuarios.isEmpty()) {
            throw new Exception("No se encontraron usuarios");
        }
        return listaUsuarios;
    }


    public Optional<VendedorModelo> buscarIdVendedor(Integer id){

        Optional<VendedorModelo> buscarVendedor= vendedorRepository.findById(id);
        if (buscarVendedor.isPresent())
        {
            System.out.println("Vendedor no existe");
        }
        return vendedorRepository.findById(id);
    }

    public void nuevoVendedor(VendedorModelo vendedorModelo) {

         vendedorRepository.save(vendedorModelo);


    }

    public Object editarVendedor(Integer id, VendedorModelo vendedorModelo)  {
        Optional<VendedorModelo> editarVendedor = vendedorRepository.findById(id);
        if (editarVendedor.isPresent())
        {
            VendedorModelo vendedorEditado = editarVendedor.get();
            vendedorEditado.setCedula_vendedor(editarVendedor.get().getCedula_vendedor());
            vendedorEditado.setNombre(editarVendedor.get().getNombre());
            vendedorEditado.setApellido(editarVendedor.get().getApellido());
            return vendedorRepository.save(vendedorEditado);

        }
        else {
            System.out.println("vendedor no encontrado");
        }


        return null;
    }

    public void removeUser(Integer id)  {
        Optional<VendedorModelo> vendedorModelo = vendedorRepository.findById(id);
        if (vendedorModelo.isPresent())
        {
            VendedorModelo vendedor = vendedorModelo.get();
            vendedorRepository.delete(vendedor);

        }
        else {
            System.out.println("Vendedor no encontrado");
        }

    }

}
