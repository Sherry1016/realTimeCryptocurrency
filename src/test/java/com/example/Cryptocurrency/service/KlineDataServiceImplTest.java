package com.example.Cryptocurrency.service;

import com.example.Cryptocurrency.model.KlineData;
import com.example.Cryptocurrency.model.KlineDataRaw;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class KlineDataServiceImplTest {

    //todo 补齐剩下的
    @Test
    public void shouldCreateKlineRaw(){
        KlineDataServiceImpl data = new KlineDataServiceImpl();
        String[] testString = {"1","2","3","4","5","6","7","8","9","10","11","12"};
        KlineDataRaw dataRaw = data.create(testString);
        assertEquals(dataRaw.getOpenTime(),1L);
        assertEquals(dataRaw.getLowPrice(),"4");
        assertEquals(dataRaw.getQuoteAssetVolume(),"8");
        assertEquals(dataRaw.getIgnore(),"12");

    }



}