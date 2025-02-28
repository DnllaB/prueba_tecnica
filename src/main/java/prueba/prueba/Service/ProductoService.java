package prueba.prueba.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prueba.prueba.Modelo.ProductoModelo;
import prueba.prueba.Modelo.VendedorModelo;
import prueba.prueba.Repository.ProductoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

      @Autowired
    private ProductoRepository productoRepository;

    public List<ProductoModelo> buscarProductos() throws Exception {
        List<ProductoModelo> listaProductos = productoRepository.findAll();
        if(listaProductos.isEmpty()) {
            throw new Exception("No se encontraron usuarios");
        }
        return listaProductos;
    }


    public Optional<ProductoModelo> buscarIdProducto(Integer id){

        Optional<ProductoModelo> buscarProducto= productoRepository.findById(id);
        if (buscarProducto.isPresent())
        {
            System.out.println("Producto no existe");
        }
        return productoRepository.findById(id);
    }


    public void nuevoProducto(ProductoModelo productoModelo) {

        productoRepository.save(productoModelo);


    }

    public Object editarProducto(Integer id, ProductoModelo productoModelo ) {
        Optional<ProductoModelo> editarProducto = productoRepository.findById(id);
        if (editarProducto.isPresent())
        {
            ProductoModelo productoEditado = editarProducto.get();
            productoEditado.setDescripcion(editarProducto.get().getDescripcion());
            productoEditado.setPrecio(editarProducto.get().getPrecio());
            productoEditado.setStock(editarProducto.get().getStock());
            productoEditado.setMarca(editarProducto.get().getMarca());
            return productoRepository.save(productoEditado);

        }
        return "Vendedor no existe";
    }

    public void removeUser(Integer id)  {
        Optional<ProductoModelo> productoModelo = productoRepository.findById(id);
        if (productoModelo.isPresent())
        {
            ProductoModelo vendedor = productoModelo.get();
            productoRepository.delete(vendedor);

        }
        else {
            System.out.println("Vendedor no encontrado");
        }

    }
}