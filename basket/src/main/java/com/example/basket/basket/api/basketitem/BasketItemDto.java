package com.example.basket.basket.api.basketitem;

import com.example.basket.basket.api.product.ProductDto;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BasketItemDto {

    private long basketItemId;
    private double basketItemAmount;
    private int count;
    private ProductDto product;

}
