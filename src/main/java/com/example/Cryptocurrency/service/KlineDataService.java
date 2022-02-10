package com.example.Cryptocurrency.service;

import com.example.Cryptocurrency.model.KlineData;

import java.util.List;

public interface KlineDataService {
    List<KlineData> klineData(String symbol, String interval, Long startTime, Long endTime);
}
