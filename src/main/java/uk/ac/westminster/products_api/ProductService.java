
package uk.ac.westminster.products_api;

import org.springframework.stereotype.Service;
import com.example.shop.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Product addProduct(Product product) {
        return repository.save(product);
    }

    public Product getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    public Optional<Product> getProductById(Long id) {
        return repository.findById(id);
    }

    public void deleteProduct(Long id) {
        repository.delete(id);
    }

    public List<Product> findByName(String name) {
        return repository.findAll().stream()
                .filter(p -> p.getName().contains(name))
                .toList();
    }

    public List<String> getAllSummaries() {
        return repository.findAll().stream()
                .map(Product::getSummary)
                .toList();
    }
}
