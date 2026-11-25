package com.example.shop.repository;


import org.springframework.stereotype.Repository;
import uk.ac.westminster.products_api.Product;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class InMemoryProductRepository implements ProductRepository {

    private final Map<Long, Product> store = new HashMap<>();
    private Long nextId = 1L;

    public InMemoryProductRepository(){
        // Your moved seed product using save()
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Product save(Product product) {

        if (product.getId() == null){
            product.setId(nextId);
            nextId++;
        }

        store.put(product.getId(), product);

        return product;
    }

    @Override
    public void delete(Long id) {
        store.remove(id);

    }
}
