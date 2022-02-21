package com.example.Cryptocurrency.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Accessors(chain = true)
@Getter
@Setter
public class KlineData {
    @NotNull
    private String openTime;
    @NotBlank
    private Double openPrice;
    @NotBlank
    private Double highPrice;
    @NotBlank
    private Double lowPrice;
    @NotBlank
    private Double closePrice;
    @NotBlank
    private Double volume;
    @NotNull
    private String closeTime;
    @NotNull
    private UUID uuid;
}
