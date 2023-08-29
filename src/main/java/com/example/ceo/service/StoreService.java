package com.example.ceo.service;

import com.example.ceo.domain.entity.Store;
import com.example.ceo.domain.request.StoreRequest;
import com.example.ceo.domain.response.StoreResponse;
import com.example.ceo.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service @RequiredArgsConstructor
public class StoreService {
    private final StoreRepository storeRepository;

    public void save(StoreRequest request, UUID ownerId){
        storeRepository.save(request.toEntity(ownerId));
    }
    public List<StoreResponse> getAll(){
        return storeRepository.findAll()
                .stream().map(StoreResponse::of)
                .toList();
    }
}
