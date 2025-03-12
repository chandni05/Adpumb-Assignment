package com.adpumb.shipproxy.controller;

import org.springframework.web.bind.annotation.*;
import com.adpumb.shipproxy.model.ProxyRequest;
import com.adpumb.shipproxy.model.ProxyResponse;
import com.adpumb.shipproxy.service.ProxyService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/shipproxy")
public class ProxyController {

    private final ProxyService proxyService;

    public ProxyController(ProxyService proxyService) {
        this.proxyService = proxyService;
    }

    @PostMapping
    public Mono<ProxyResponse> handleRequest(@RequestBody ProxyRequest request) {
        return proxyService.forwardRequest(request);
    }
}
