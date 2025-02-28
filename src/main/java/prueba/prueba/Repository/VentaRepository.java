package prueba.prueba.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import prueba.prueba.Modelo.VendedorModelo;
import prueba.prueba.Modelo.VentaModelo;

import java.util.Optional;

public interface VentaRepository extends JpaRepository <VentaModelo, Integer> {

    Optional<VentaModelo> findById(Integer id);
}

