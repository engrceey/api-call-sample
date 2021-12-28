package com.zurumdev.externalcalls.controller;


import com.zurumdev.externalcalls.dtos.ApiResponse;
import com.zurumdev.externalcalls.service.CryptoNamesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "crypto")
public class CryptoController {

    @Autowired
    private final CryptoNamesService cryptoNamesService;

    @GetMapping("names")
    public ResponseEntity<ApiResponse<String>> fetchUsers() {

        String response = cryptoNamesService.getCryptoNames();

        return ResponseEntity.ok().body(ApiResponse.<String>builder()
                .data(response)
                .statusMessage("SUCCESS")
                .statusCode(HttpStatus.OK.toString())
                .successful(true)
                .build());
    }
}
