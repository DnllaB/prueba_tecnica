package prueba.prueba.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import prueba.prueba.Modelo.VendedorModelo;

import java.util.Optional;


@Repository
public interface VendedorRepository extends JpaRepository <VendedorModelo, Integer>{

    Optional<VendedorModelo> findById(Integer id);

}
