package com.adpumb.offshoreproxy.service;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.adpumb.offshoreproxy.model.ProxyRequest;
import com.adpumb.offshoreproxy.model.ProxyResponse;

import reactor.core.publisher.Mono;

@Service
public class ProxyService {

    private final WebClient webClient = WebClient.create();

    public Mono<ProxyResponse> forwardRequest(ProxyRequest request) {
        return webClient.method(HttpMethod.valueOf(request.getMethod()))
                .uri(request.getUrl())
                .headers(headers -> headers.setAll(request.getHeaders()))
                .bodyValue(request.getBody() != null ? request.getBody() : "")
                .retrieve()
                .bodyToMono(String.class)
                .map(responseBody -> new ProxyResponse(responseBody, 200));
    }
}
