package com.adpumb.shipproxy.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import com.adpumb.shipproxy.model.ProxyRequest;
import com.adpumb.shipproxy.model.ProxyResponse;

import reactor.core.publisher.Mono;

@Service
public class ProxyService {
    
    private final WebClient webClient = WebClient.create("http://localhost:8000");

    public Mono<ProxyResponse> forwardRequest(ProxyRequest request) {
        return webClient.post()
                .uri("/offshoreproxy")
                .bodyValue(request)
                .retrieve()
                .bodyToMono(ProxyResponse.class);
    }
}
