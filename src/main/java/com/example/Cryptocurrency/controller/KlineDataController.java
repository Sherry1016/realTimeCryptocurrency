package com.example.Cryptocurrency.controller;

import com.example.Cryptocurrency.service.KlineDataService;
import com.example.Cryptocurrency.service.KlineDataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KlineDataController {
    @Autowired
    private KlineDataService service;

    @GetMapping("/GET/api/v3/klines")
    public Object Kline(String symbol, String interval, Long startTime, Long endTime){

        return service.klineData(symbol, interval, startTime, endTime);
    }
}
