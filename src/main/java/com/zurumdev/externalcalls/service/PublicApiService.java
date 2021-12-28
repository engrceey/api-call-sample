package com.zurumdev.externalcalls.service;


import com.zurumdev.externalcalls.dtos.PublicApis;
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
public class PublicApiService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${public.apis.base-url}")
    private String PUBLIC_BASE_URL;

    public PublicApis getPublicApi() {

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        return restTemplate.exchange(PUBLIC_BASE_URL, HttpMethod.GET, entity, PublicApis.class).getBody();

    }
}
