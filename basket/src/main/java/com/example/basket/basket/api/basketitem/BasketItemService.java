package com.example.basket.basket.api.basketitem;

import com.example.basket.basket.impl.basketitem.BasketItem;

public interface BasketItemService {
    BasketItem findBasketItemByBasketIdAndProductId(long basketId, long productId);

    BasketItem save(BasketItem basketItem);

    void delete(long basketItemId);
}
