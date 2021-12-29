package com.zurumdev.externalcalls.dtos;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class Placeholder implements Serializable {
    private int userId;

    @NotBlank(message = "id cannot be empty")
    private int id;
    private String title;
    private boolean completed;
}
