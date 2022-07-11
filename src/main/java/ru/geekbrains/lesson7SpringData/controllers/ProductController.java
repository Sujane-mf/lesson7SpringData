package ru.geekbrains.lesson7SpringData.controllers;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.lesson7SpringData.model.Product;
import ru.geekbrains.lesson7SpringData.services.ProductService;

import java.util.List;

@RestController
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    //контроллер для поиска всех товаров
    @GetMapping("/products")
    public List<Product> findAll(){
        return productService.findAll();
    }

    //контроллер для поиска товаров дешевле максимальной цены: http://localhost:8189/app/products/price/beforemax?max=30
    @GetMapping("/products/price/beforemax")
    public List<Product> findByPriceIsBefore(@RequestParam (name = "max") int maxPrice){
        return productService.findByPriceIsBefore(maxPrice);
    }
    //контроллер для поиска товаров дороже минимальной цены: http://localhost:8189/app/products/price/aftermin?min=2
    @GetMapping("/products/price/aftermin")
    public List<Product> findByPriceGreaterThan(@RequestParam (name = "min") int minPrice){
        return productService.findByPriceGreaterThan(minPrice);
    }
    //контроллер для поиска товаров между минимальной и максимальной: http://localhost:8189/app/products/price/between?min=2&max=30
    @GetMapping("/products/price/between")
    public List<Product> findByPriceIsBetween(@RequestParam (name = "min") int minPrice, @RequestParam(name = "max") int maxPrice){
        return productService.findByPriceIsBetween(minPrice, maxPrice);
    }

    //контроллер для поиска товара по его id
    @GetMapping("/products/{id}")
    public Product findById(@PathVariable Long id){
        return productService.findById(id).get();
    }

    @PostMapping("/products")
    @ResponseStatus(HttpStatus.CREATED)
    public Product save(@RequestBody Product product) {
        Product new_product = new Product();
        new_product.setId(product.getId());
        new_product.setTitle(product.getTitle());
        new_product.setPrice(product.getPrice());
        return productService.save(new_product);
    }

    //контроллер для апдейта товара
    @PutMapping("/products")
    public void updateProduct(@RequestBody Product product)
    {
        productService.updateProduct(product);
    }

    //контроллер для удаления товара по его id
    @GetMapping("/products/delete")
    public void deleteById(@RequestParam (name = "id") Long id){
        productService.deleteById(id);
    }

    //удаление по id 2ой вариант
    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteById(id);
    }

}
