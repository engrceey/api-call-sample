package com.zurumdev.externalcalls.controller;


import com.zurumdev.externalcalls.dtos.ApiResponse;
import com.zurumdev.externalcalls.dtos.Reqbin;
import com.zurumdev.externalcalls.dtos.ReqbinResponse;
import com.zurumdev.externalcalls.service.ReqbinService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "reqbin")
public class ReqbinController {

    @Autowired
    private final ReqbinService reqbinService;

    @PostMapping()
    public ResponseEntity<ApiResponse<ReqbinResponse>> postReqbin(@RequestBody Reqbin model) {

        ReqbinResponse response = reqbinService.postReqbin(model);

        return ResponseEntity.ok().body(ApiResponse.<ReqbinResponse>builder()
                .data(response)
                .statusMessage("SUCCESS")
                .statusCode(HttpStatus.OK.toString())
                .successful(true)
                .build());
    }

}
