package conocimientoCorporativoBack.prueba.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import conocimientoCorporativoBack.prueba.entity.Product;

@Repository("productoRepository")
public interface ProductoRepository extends JpaRepository<Product,Serializable> {

    
}
