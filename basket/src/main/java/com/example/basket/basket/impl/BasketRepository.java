package com.example.basket.basket.impl;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketRepository extends JpaRepository<Basket,Long> {

    Basket findBasketByUserIdAndStatusEquals(long userId, int basketStatusNone);

    Basket findBasketByBasketId(long basketId);
}
