package com.example.basket.basket.web;

import com.example.basket.basket.api.BasketDto;
import com.example.basket.basket.api.BasketService;
import com.example.basket.basket.impl.BasketRepository;
import com.example.basket.basket.impl.BasketServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/baskets")
public class BasketController {

    private final BasketService basketService;


    public BasketController(BasketService basketService) {
        this.basketService = basketService;
    }

    @PostMapping("/addProductToBasket")
    public BasketResponse addProductToBasket (@RequestBody AddProductRequest addProductRequest){

        return toResponse(basketService.addProductToBasket(addProductRequest.toDto()));
    }

    @DeleteMapping("/delete/{id}")
    public String removerBasketItem(@PathVariable String userId, @PathVariable String basketItemId){

        basketService.removeProductFromBasket(userId,basketItemId);

        return "Ürün başarıyla silindi";
    }

    @GetMapping("/{userId}")
    public ResponseEntity<BasketResponse> getBasketByUserId(@PathVariable String userId){
        return ResponseEntity.ok(toResponse(basketService.getBasketByUserId(userId)));
    }


    public BasketResponse toResponse(BasketDto basketDto) {
        return BasketResponse.builder()
                .basketId(basketDto.getBasketId())
                .totalAmount(basketDto.getTotalAmount())
                .status(basketDto.getStatus())
                .userId(basketDto.getUserId())
                .basketItemList(basketDto.getBasketItemList())
                .build();
    }

}
