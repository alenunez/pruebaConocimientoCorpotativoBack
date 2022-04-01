package conocimientoCorporativoBack.prueba.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import conocimientoCorporativoBack.prueba.entity.Product;
import conocimientoCorporativoBack.prueba.repository.ProductoRepository;

@RestController
@RequestMapping("/producto")
@CrossOrigin
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping("/buscar")
    public List<Product> getAlProductos() {
        return productoRepository.findAll();
    }



    @GetMapping("/buscar/{id}")
    public Product findById(@PathVariable final Long id) {
        Product producto = new Product();
        List<Product> productos = productoRepository.findAll();
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getId() == id) {
                producto = productos.get(i);
            } else {
                producto = null;
            }
        }
        return producto;
    }

    @PostMapping("/guardar")
    public Product saveProduct(@RequestBody Product prod) {
        return productoRepository.save(prod);
    }

    @DeleteMapping("/eliminar/{id}")
    public void deleteRol(@PathVariable("id") int id) {
        Optional<Product> producto;
        producto = productoRepository.findById(id);
        if (producto.isPresent()) {
            productoRepository.delete(producto.get());
        }
    }

}
