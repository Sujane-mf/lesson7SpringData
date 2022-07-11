package ru.geekbrains.lesson7SpringData.controllers;

import org.springframework.web.bind.annotation.*;
import ru.geekbrains.lesson7SpringData.model.Cart;
import ru.geekbrains.lesson7SpringData.model.Product;
import ru.geekbrains.lesson7SpringData.services.CartService;
import ru.geekbrains.lesson7SpringData.services.ProductService;

import java.util.List;

@RestController
public class CartController {
    private CartService cartService;
    private ProductService productService;

    public CartController(CartService cartService, ProductService productService) {
        this.cartService = cartService;
        this.productService = productService;
    }

    //контроллер для отображения всех корзин
    @GetMapping("/carts")
    public List<Cart> findAll(){
        return cartService.findAll();
    }

    //контроллер для добавления товара в корзину
    @PutMapping("/carts_add")
    public void updateCartAddProduct(@RequestBody Product product, @RequestParam (name = "id") Long id)
    {
        productService.addProductToCartByCartId(id, product);
    }

    //контроллер для удаления товара из корзины
    @PutMapping("/carts_delete")
    public void updateCartDeleteProduct(@RequestBody Product product, @RequestParam (name = "id") Long id)
    {
        productService.addProductToCartByCartId(id, product);
    }

    //контроллер для удаления корзины
    @DeleteMapping("/carts/{id}")
    public void deleteProduct(@PathVariable Long id){
        cartService.deleteById(id);
    }

}
