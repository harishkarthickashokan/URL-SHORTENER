package com.example.url_shortener.dto;

public class UrlRequest {

    private String originalUrl;

    public UrlRequest() {
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }
}