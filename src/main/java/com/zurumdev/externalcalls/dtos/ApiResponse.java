package com.zurumdev.externalcalls.dtos;


import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class ApiResponse<T> implements Serializable {

    private String statusCode;
    private String statusMessage;
    private Boolean successful;
    private T data;

}