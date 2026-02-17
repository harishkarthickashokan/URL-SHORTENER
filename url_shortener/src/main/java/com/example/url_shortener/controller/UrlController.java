package com.example.url_shortener.controller;

import com.example.url_shortener.dto.UrlRequest;
import com.example.url_shortener.service.UrlService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api")
public class UrlController {

    private final UrlService urlService;

    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }
    @RestController
    public class TestController {

        @GetMapping("/test")
        public String test() {
            return "Controller works";
        }
    }

    @PostMapping("/shorten")
    public String shortenUrl(@RequestBody UrlRequest request) {
        return "http://localhost:8080/" + urlService.shortenUrl(request.getOriginalUrl());
    }

    @GetMapping("/{shortCode}")
    public ResponseEntity<Void> redirect(@PathVariable String shortCode) {

        String originalUrl = urlService.getOriginalUrl(shortCode);

        if (!originalUrl.startsWith("http://") && !originalUrl.startsWith("https://")) {
            originalUrl = "https://" + originalUrl;
        }

        return ResponseEntity
                .status(HttpStatus.FOUND)
                .location(URI.create(originalUrl))
                .build();
    }
}