package com.zurumdev.externalcalls.controller;


import com.zurumdev.externalcalls.dtos.ApiResponse;
import com.zurumdev.externalcalls.dtos.PublicApis;
import com.zurumdev.externalcalls.service.PublicApiService;
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
@RequestMapping(path = "public")
public class PublicApiController {

    @Autowired
    private final PublicApiService publicApiService;

    @GetMapping("apis")
    public ResponseEntity<ApiResponse<PublicApis>> fetchPublicApis() {

        PublicApis response = publicApiService.getPublicApi();

        return ResponseEntity.ok().body(ApiResponse.<PublicApis>builder()
                .data(response)
                .statusMessage("SUCCESS")
                .statusCode(HttpStatus.OK.toString())
                .successful(true)
                .build());
    }

}
