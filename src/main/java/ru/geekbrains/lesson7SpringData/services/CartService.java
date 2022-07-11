package ru.geekbrains.lesson7SpringData.services;

import org.springframework.stereotype.Service;
import ru.geekbrains.lesson7SpringData.model.Cart;
import ru.geekbrains.lesson7SpringData.model.Product;
import ru.geekbrains.lesson7SpringData.repositories.CartRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    private CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public Optional<Cart> findById(Long id){
        return cartRepository.findById(id);
    }
    public List<Cart> findAll(){return cartRepository.findAll();}

    public List<Product> findAllProductsInCartByCartId(Long id){
        return cartRepository.findById(id).get().getProducts();
    }

    public void addProductToCart(Long cartId, Product product){
        cartRepository.findById(cartId).get().getProducts().add(product);
    }

    public void deleteProductFromCart(Long cartId, Product product){
        cartRepository.findById(cartId).get().getProducts().remove(product);
    }

    public void deleteById(Long id){
        cartRepository.deleteById(id);
    }
}
