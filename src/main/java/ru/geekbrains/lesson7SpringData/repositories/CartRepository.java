package ru.geekbrains.lesson7SpringData.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.lesson7SpringData.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

}
