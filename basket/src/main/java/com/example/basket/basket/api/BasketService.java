package com.example.basket.basket.api;

public interface BasketService {
    BasketDto addProductToBasket(BasketDto dto);

    void removeProductFromBasket(String userId, String basketItemId);

    BasketDto getBasketByUserId(String userId);
}
