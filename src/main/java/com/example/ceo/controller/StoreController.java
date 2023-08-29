package com.example.ceo.controller;

import com.example.ceo.domain.request.StoreRequest;
import com.example.ceo.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/store")
public class StoreController {
    private final StoreService storeService;
    public static UUID uuid = UUID.randomUUID();
    @PostMapping @ResponseStatus(HttpStatus.CREATED)
    public void postStore(@RequestBody StoreRequest request){
        storeService.save(request, uuid);
    }


}
