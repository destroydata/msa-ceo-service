package com.example.ceo.controller;

import com.example.ceo.domain.request.MenuRequest;
import com.example.ceo.domain.response.MenuResponse;
import com.example.ceo.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/menu")
public class MenuController {
    private final MenuService menuService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void postMenu(@RequestBody MenuRequest request){
        menuService.save(request);
    }

    @GetMapping("/store/{id}")
    public Page<MenuResponse> getByStoreId(
            @PathVariable("id") Long storeId,
            @RequestParam(
                    required = false,
                    defaultValue = "0",
                    name = "page"
            ) Integer page,
            @RequestParam(
                    required = false,
                    defaultValue = "10",
                    name = "size"
            ) Integer size
    ){
        return menuService
                .getByStoreId(storeId, PageRequest.of(page,size));
    }


}
