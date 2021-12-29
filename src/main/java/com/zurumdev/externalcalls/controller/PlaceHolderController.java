package com.zurumdev.externalcalls.controller;


import com.zurumdev.externalcalls.dtos.ApiResponse;
import com.zurumdev.externalcalls.dtos.Placeholder;
import com.zurumdev.externalcalls.service.PlaceHolderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "placeholder")
public class PlaceHolderController {

    @Autowired
    private final PlaceHolderService placeHolderService;

    @GetMapping(value = "apis", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<Placeholder[]>> fetchPlaceholderApis() {

        Placeholder[] response = placeHolderService.getPlaceHolders();

        return ResponseEntity.ok().body(ApiResponse.<Placeholder[]>builder()
                .data(response)
                .statusMessage("SUCCESS")
                .statusCode(HttpStatus.OK.toString())
                .successful(true)
                .build());
    }

    @GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<ApiResponse<Placeholder>> fetchPlaceholderById(@PathVariable("id") int id) {

        Placeholder response = placeHolderService.getPlaceHolderById(id);

        return ResponseEntity.ok().body(ApiResponse.<Placeholder>builder()
                .data(response)
                .statusMessage("SUCCESS")
                .statusCode(HttpStatus.OK.toString())
                .successful(true)
                .build());
    }



}
