package com.zurumdev.externalcalls.service;

import com.zurumdev.externalcalls.dtos.Reqbin;
import com.zurumdev.externalcalls.dtos.ReqbinResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ReqbinService {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${reqbin.apis.base-url}")
    private String REQBIN_BASE_URL;

    public ReqbinResponse postReqbin(Reqbin model) {
        return restTemplate.postForObject(REQBIN_BASE_URL,model,ReqbinResponse.class);
    }
}
