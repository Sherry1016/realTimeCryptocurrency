package com.example.Cryptocurrency.service;

import com.example.Cryptocurrency.model.KlineData;
import com.example.Cryptocurrency.model.KlineDataRaw;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.text.Format;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TransformationServiceTest {
    @Autowired
    TransformationService TransformData;


    @Test
    @BeforeEach
    public void shouldTransformation(){
        KlineDataRaw rawData = new KlineDataRaw();
        rawData.setOpenTime(Long.parseLong("1523577600000"));
        rawData.setOpenPrice("2");
        rawData.setHighPrice("3");
        rawData.setLowPrice("4");
        rawData.setClosePrice("5");
        rawData.setVolume("6");
        rawData.setCloseTime(Long.parseLong("1523577600000"));
        rawData.setUuid(UUID.randomUUID());
        KlineData klineData = TransformData.transformation(rawData);
        assertEquals(klineData.getClosePrice(), 5);
        assertEquals(klineData.getVolume(), 6);




    }



}