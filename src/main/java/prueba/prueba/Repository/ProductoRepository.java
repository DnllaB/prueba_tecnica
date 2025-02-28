package prueba.prueba.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import prueba.prueba.Modelo.ProductoModelo;
import prueba.prueba.Modelo.VendedorModelo;

import java.util.Optional;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoModelo, Integer> {

    Optional<ProductoModelo> findById(Integer id);
}
