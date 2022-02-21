package com.example.Cryptocurrency.service;


import com.example.Cryptocurrency.model.KlineData;
import com.example.Cryptocurrency.model.KlineDataRaw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.text.Format;
import java.text.SimpleDateFormat;

@Service
public class TransformationService {
    @Autowired
    private Format timeFormat;

    // todo test this function
    public KlineData transformation(@NotNull @Valid KlineDataRaw rawData){
        return new KlineData()
                .setOpenTime(timeFormat.format(new Date(rawData.getOpenTime())))
                .setOpenPrice(Double.parseDouble(rawData.getOpenPrice()))
                .setHighPrice(Double.parseDouble(rawData.getHighPrice()))
                .setLowPrice(Double.parseDouble(rawData.getLowPrice()))
                .setClosePrice(Double.parseDouble(rawData.getClosePrice()))
                .setVolume(Double.parseDouble(rawData.getVolume()))
                .setCloseTime(timeFormat.format(new Date(rawData.getCloseTime())))
                .setUuid(rawData.getUuid());
    }

}
