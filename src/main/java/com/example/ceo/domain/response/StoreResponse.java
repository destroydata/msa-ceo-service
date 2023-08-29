package com.example.ceo.domain.response;

import com.example.ceo.domain.entity.Store;

public record StoreResponse(
        Long id,
        String location,
        String name,
        String img
) {
    public static StoreResponse of(Store store){
        return new StoreResponse(
                store.getId()
                , store.getLocation()
                , store.getName()
                , store.getImg()
                );
    }
}
