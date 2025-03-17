package com.example.basket.basket.impl;

import com.example.basket.basket.api.basketitem.BasketItemDto;
import com.example.basket.basket.impl.basketitem.BasketItem;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long basketId;
    private double totalAmount;
    private int status;
    private long userId;
    @OneToMany(mappedBy = "basket" , cascade = CascadeType.ALL)
    private List<BasketItem> basketItemList;
}
