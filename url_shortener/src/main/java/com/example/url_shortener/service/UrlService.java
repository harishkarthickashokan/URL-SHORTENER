package com.example.url_shortener.service;

import com.example.url_shortener.model.Url;
import com.example.url_shortener.repository.UrlRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UrlService {

    private final UrlRepository urlRepository;


    public UrlService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    public String shortenUrl(String originalUrl) {
        String shortCode = generateShortCode();

        Url url = new Url();
        url.setOriginalUrl(originalUrl);
        url.setShortUrl(shortCode);

        urlRepository.save(url);

        return shortCode;
    }

    public String getOriginalUrl(String shortCode) {
        Url url = urlRepository.findByShortUrl(shortCode)
                .orElseThrow(() -> new RuntimeException("Short URL not found"));

        if (url.getOriginalUrl() == null || url.getOriginalUrl().isBlank()) {
            throw new RuntimeException("Original URL is empty in DB");
        }

        return url.getOriginalUrl();
    }

    private String generateShortCode() {
        return UUID.randomUUID().toString().substring(0, 6);
    }
}