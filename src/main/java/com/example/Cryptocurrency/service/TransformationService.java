package com.example.Cryptocurrency.service;


import com.example.Cryptocurrency.dao.KlineDataDao;
import com.example.Cryptocurrency.model.KlineData;
import com.example.Cryptocurrency.model.KlineDataRaw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransformationService {

    public KlineData transformation(KlineDataRaw rawData){
        KlineData klineData = new KlineData();
        klineData.setOpenTime(rawData.getOpenTime().toString());
        klineData.setOpenPrice(Double.parseDouble(rawData.getOpenPrice()));
        klineData.setHighPrice(Double.parseDouble(rawData.getHighPrice()));
        klineData.setLowPrice(Double.parseDouble(rawData.getLowPrice()));
        klineData.setClosePrice(Double.parseDouble(rawData.getClosePrice()));
        klineData.setVolume(Long.parseLong(rawData.getVolume()));
        klineData.setCloseTime(rawData.getCloseTime().toString());
        klineData.setUuid(rawData.getUuid());
        return klineData;
    }

}
