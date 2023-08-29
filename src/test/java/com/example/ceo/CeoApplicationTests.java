package com.example.ceo;

import com.example.ceo.domain.entity.Menu;
import com.example.ceo.domain.entity.Owner;
import com.example.ceo.domain.entity.Store;
import com.example.ceo.domain.response.MenuResponse;
import com.example.ceo.repository.MenuRepository;
import com.example.ceo.repository.OwnerRepository;
import com.example.ceo.repository.StoreRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.UUID;

@SpringBootTest
class CeoApplicationTests {
	@Autowired
	OwnerRepository ownerRepository;
	@Autowired
	StoreRepository storeRepository;
	@Autowired
	MenuRepository menuRepository;

	@Test
	void contextLoads() {
		Owner owner = ownerRepository.save(Owner.builder().number("1").name("1").build());
		Store store = storeRepository.save(Store.builder().owner(owner).name("dsa").img("sad").build());
		for (int i = 0; i < 3; i++) {
			menuRepository.save(Menu.builder().price(i).name("asd"+i).store(store).build());
		}
		Page<MenuResponse> byStore = menuRepository.findByStore(store.getId(), PageRequest.of(0, 10));

		System.out.println(byStore.getContent());
	}

}
