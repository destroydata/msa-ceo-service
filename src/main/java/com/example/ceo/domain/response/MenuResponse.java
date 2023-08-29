package com.example.ceo.domain.response;

import com.example.ceo.domain.entity.Menu;

public record MenuResponse(
        Long id, String name,Integer price) {
    public static MenuResponse of(Menu menu){
        return new MenuResponse(
                menu.getId(), menu.getName(), menu.getPrice()
        );
    }
}
