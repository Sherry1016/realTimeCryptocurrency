package com.example.Cryptocurrency.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Accessors(chain = true)
@Getter
@Setter
public class KlineData {
    @NotNull
    private String openTime; // todo: fix error, time converter
    @NotBlank
    private Double openPrice;
    @NotBlank
    private Double highPrice;
    @NotBlank
    private Double lowPrice;
    @NotBlank
    private Double closePrice;
    @NotBlank
    private Long volume; // todo:
    @NotNull
    private String closeTime; // todo: fix error, time converter, create bean, simpleDataFormat
    @NotNull
    private UUID uuid;
}
