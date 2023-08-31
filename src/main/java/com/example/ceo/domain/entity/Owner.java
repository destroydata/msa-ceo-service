package com.example.ceo.domain.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Table(name="Owners") @Entity
@AllArgsConstructor @NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder @Getter
public class Owner {
    @Id
    private UUID id;
    private String name;
    private String number;
    @OneToMany(mappedBy = "owner")
    private List<Store> stores;
}
