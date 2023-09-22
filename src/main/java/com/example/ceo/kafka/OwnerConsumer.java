package com.example.ceo.kafka;

import com.example.ceo.domain.request.OwnerRequest;
import com.example.ceo.service.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OwnerConsumer {
    private final OwnerService service;
    @KafkaListener(topics = TopicConfig.ownerTopic)
    public void listen(OwnerRequest request){
        service.save(request);
    }
}
