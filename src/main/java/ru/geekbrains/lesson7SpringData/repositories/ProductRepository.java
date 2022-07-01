package ru.geekbrains.lesson7SpringData.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.lesson7SpringData.model.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByPriceIsBefore(int maxPrice);
    List<Product> findByPriceGreaterThan(int minPrice);
    List<Product> findByPriceIsBetween(int minPrice, int maxPrice);

}
