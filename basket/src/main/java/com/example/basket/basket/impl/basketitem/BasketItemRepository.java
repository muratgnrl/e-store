package com.example.basket.basket.impl.basketitem;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketItemRepository extends JpaRepository<BasketItem,Long> {

    BasketItem findBasketItemByBasket_BasketIdAndProductId(long basketItemId, long productId);
}
