package com.example.Cryptocurrency.service;

import com.example.Cryptocurrency.dao.KlineDataDao;
import com.example.Cryptocurrency.model.KlineData;
import com.example.Cryptocurrency.model.KlineDataRaw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class KlineDataServiceImpl implements KlineDataService {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private KlineDataDao dao;
    @Autowired
    private TransformationService transform;

    @Value("${url}")
    private String urlTemplate;

    // todo test this function
    public KlineDataRaw create(String[] dataRow){
        return new KlineDataRaw()
                .setOpenTime(Long.parseLong(dataRow[0]))
                .setOpenPrice(dataRow[1])
                .setHighPrice(dataRow[2])
                .setLowPrice(dataRow[3])
                .setClosePrice(dataRow[4])
                .setVolume(dataRow[5])
                .setCloseTime(Long.parseLong(dataRow[6]))
                .setQuoteAssetVolume(dataRow[7])
                .setTrades(Integer.parseInt(dataRow[8]))
                .setTakerBaseAssetVol(dataRow[9])
                .setTakerQuoteAssetVol(dataRow[10])
                .setIgnore(dataRow[11])
                .setUuid(UUID.randomUUID());
    }


    public List<KlineData> klineData(@NotBlank String symbol, @NotBlank String interval, @NotNull Long startTime, @NotNull Long endTime) {
        String url = String.format(urlTemplate, symbol, interval, startTime, endTime);
        ResponseEntity<String[][]> response
                = restTemplate.getForEntity(url, String[][].class);
        String[][] body = response.getBody();

        assert body != null;
        List<KlineDataRaw> rawData = Arrays.stream(body).parallel()
                .map(dataRow -> create(dataRow))
                //.map(this::create)
                .collect(Collectors.toList());

        //dao.insert(data);
        dao.batchInsert(rawData);


        List<KlineData> klineDataList = rawData.stream()
                .map(data -> transform.transformation(data))
                .collect(Collectors.toList());

        dao.batchInsertKlineData(klineDataList);


        return klineDataList;
    }




}