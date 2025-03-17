package com.example.basket.basket.api;

import com.example.basket.basket.api.basketitem.BasketItemDto;
import lombok.*;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BasketDto {

    private long basketId;
    private double totalAmount;
    private int status;
    private long userId;
    private List<BasketItemDto> basketItemList;
}
