package com.example.basket.basket.web;

import com.example.basket.basket.api.basketitem.BasketItemDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class BasketResponse {

    private  long basketId;
    private  double totalAmount;
    private  int status;
    private  long userId;
    private List<BasketItemDto> basketItemList;
}
