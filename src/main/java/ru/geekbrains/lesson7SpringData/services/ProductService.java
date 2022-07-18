package ru.geekbrains.lesson7SpringData.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.lesson7SpringData.model.Product;
import ru.geekbrains.lesson7SpringData.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productRepository;
    private CartService cartService;

    public ProductService(ProductRepository productRepository, CartService cartService) {
        this.productRepository = productRepository;
        this.cartService = cartService;
    }

    public void addProductToCartByCartId(Long cartId, Product product){
      cartService.addProductToCart(cartId, product);
    }

    public void deleteProductFromCartByCartId(Long cartId, Product product){
        cartService.deleteProductFromCart(cartId, product);
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Page<Product> findAll(int pageIndex, int pageSize){
        return productRepository.findAll(PageRequest.of(pageIndex, pageSize));
    }

    public List<Product> findByPriceIsBefore(int maxPrice){
        return productRepository.findByPriceIsBefore(maxPrice);
    }

    public List<Product> findByPriceGreaterThan(int minPrice) {
        return productRepository.findByPriceGreaterThan(minPrice);
    }

    public List<Product> findByPriceIsBetween(int minPrice, int maxPrice) {
        return productRepository.findByPriceIsBetween(minPrice, maxPrice);
    }

    public Optional<Product> findById(Long id){
        return productRepository.findById(id);
    }

    public Product save(Product product){
        return productRepository.save(product);
    }

    @Transactional
    public void updateProduct(Product product){
        Product updated_product = findById(product.getId()).get();
        updated_product.setTitle(product.getTitle());
        updated_product.setPrice(product.getPrice());
    }
    public void deleteById(Long id){
        productRepository.deleteById(id);
    }

}
