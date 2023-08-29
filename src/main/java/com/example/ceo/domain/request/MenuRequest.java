package com.example.ceo.domain.request;

import com.example.ceo.domain.entity.Menu;
import com.example.ceo.domain.entity.Store;

public record MenuRequest(
        String name
        , Integer price
        , Long storeId
) {
    public Menu toEntity(){
        return Menu.builder()
                .name(name)
                .price(price)
                .store(Store.builder()
                        .id(storeId)
                        .build())
                .build();
    }
}
