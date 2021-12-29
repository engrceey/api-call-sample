package com.zurumdev.externalcalls.service;

import com.zurumdev.externalcalls.dtos.Placeholder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Slf4j
@Service
@RequiredArgsConstructor
public class PlaceHolderService {

    @Autowired
    RestTemplate restTemplate;

    @Value("${placeholder.apis.base-url}")
    private String PLACE_HOLDER_URL;

    public Placeholder[] getPlaceHolders() {

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        return restTemplate.exchange(PLACE_HOLDER_URL, HttpMethod.GET, entity, Placeholder[].class).getBody();
    }

    public Placeholder getPlaceHolderById(int id) {

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        return restTemplate.exchange(PLACE_HOLDER_URL+id, HttpMethod.GET, entity, Placeholder.class).getBody();
    }

}
