package com.adpumb.offshoreproxy.controller;

import org.springframework.web.bind.annotation.*;

import com.adpumb.offshoreproxy.model.ProxyRequest;
import com.adpumb.offshoreproxy.model.ProxyResponse;
import com.adpumb.offshoreproxy.service.ProxyService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/offshoreproxy")
public class ProxyController {

    private final ProxyService proxyService;

    public ProxyController(ProxyService proxyService) {
        this.proxyService = proxyService;
    }

    @PostMapping
    public Mono<ProxyResponse> forwardRequest(@RequestBody ProxyRequest request) {
        return proxyService.forwardRequest(request);
    }
}
