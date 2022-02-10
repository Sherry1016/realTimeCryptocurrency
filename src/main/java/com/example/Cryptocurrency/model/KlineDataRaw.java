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
public class KlineDataRaw {
    @NotNull
    private Long openTime;
    @NotBlank
    private String openPrice;
    @NotBlank
    private String highPrice;
    @NotBlank
    private String lowPrice;
    @NotBlank
    private String closePrice;
    @NotBlank
    private String volume;
    @NotNull
    private Long closeTime;
    @NotBlank
    private String quoteAssetVolume;
    @Min(value = 0, message = "None of the trades can be zero")
    private Integer trades;
    @NotBlank
    private String takerBaseAssetVol;
    @NotBlank
    private String takerQuoteAssetVol;
    @NotBlank
    private String ignore;
    @NotNull
    private UUID uuid;
}
