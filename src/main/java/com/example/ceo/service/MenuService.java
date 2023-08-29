package com.example.ceo.service;

import com.example.ceo.domain.entity.Menu;
import com.example.ceo.domain.entity.Store;
import com.example.ceo.domain.request.MenuRequest;
import com.example.ceo.domain.response.MenuResponse;
import com.example.ceo.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service @RequiredArgsConstructor
public class MenuService {
    private final MenuRepository menuRepository;
    public void save(MenuRequest request){
        menuRepository.save(request.toEntity());
    }

    public Page<MenuResponse> getByStoreId(Long storeId, PageRequest request){
        return menuRepository.findByStore(
                storeId,
                request
        );
    }

}
