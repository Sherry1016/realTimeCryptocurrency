package com.example.Cryptocurrency.dao;

import com.example.Cryptocurrency.model.KlineData;
import com.example.Cryptocurrency.model.KlineDataRaw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StopWatch;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Transactional
@Repository
public class KlineDataDao {
    @Autowired
    private JdbcTemplate jdbc;

    public void insert(@NotEmpty List<@NotNull @Valid KlineDataRaw> dataList) {
        StopWatch timer = new StopWatch();
        timer.start();
        System.out.println("batchInsert -> Total time in seconds: " + timer.getTotalTimeSeconds());
        for (KlineDataRaw i : dataList) {
            jdbc.update("INSERT INTO market_data_kline_raw VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                    i.getOpenTime(), i.getOpenPrice(), i.getHighPrice(), i.getLowPrice(), i.getClosePrice(),
                    i.getVolume(), i.getCloseTime(), i.getQuoteAssetVolume(), i.getTrades(), i.getTakerBaseAssetVol(),
                    i.getTakerQuoteAssetVol(), i.getIgnore(), i.getUuid());
        }
        timer.stop();
        System.out.println("batchInsert -> Total time in seconds: " + timer.getTotalTimeSeconds());
    }

    public void batchInsert(@NotEmpty List<@NotNull @Valid KlineDataRaw> dataList) {
            StopWatch timer = new StopWatch();
            String sql = "INSERT INTO market_data_kline_raw VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            timer.start();
            jdbc.batchUpdate(sql, new BatchPreparedStatementSetter() {

                @Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    KlineDataRaw dataRaw = dataList.get(i);
                    ps.setLong(1, dataRaw.getOpenTime());
                    ps.setString(2, dataRaw.getOpenPrice());
                    ps.setString(3, dataRaw.getHighPrice());
                    ps.setString(4, dataRaw.getLowPrice());
                    ps.setString(5, dataRaw.getClosePrice());
                    ps.setString(6, dataRaw.getVolume());
                    ps.setLong(7, dataRaw.getCloseTime());
                    ps.setString(8, dataRaw.getQuoteAssetVolume());
                    ps.setInt(9, dataRaw.getTrades());
                    ps.setString(10, dataRaw.getTakerBaseAssetVol());
                    ps.setString(11, dataRaw.getTakerQuoteAssetVol());
                    ps.setString(12, dataRaw.getIgnore());
                    ps.setObject(13, dataRaw.getUuid());
                }

                @Override
                public int getBatchSize() {
                    return dataList.size();
                }
            });
            timer.stop();
            System.out.println("batchInsert -> Total time in seconds: " + timer.getTotalTimeSeconds());
    }

    public void batchInsertKlineData(@NotEmpty List<@NotNull @Valid KlineData> dataList) {
        String sql = "INSERT INTO market_data_kline VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        jdbc.batchUpdate(sql, new BatchPreparedStatementSetter() {

            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                KlineData data = dataList.get(i);
                ps.setString(1, data.getOpenTime());
                ps.setDouble(2, data.getOpenPrice());
                ps.setDouble(3, data.getHighPrice());
                ps.setDouble(4, data.getLowPrice());
                ps.setDouble(5, data.getClosePrice());
                ps.setDouble(6, data.getVolume());
                ps.setString(7, data.getCloseTime());
                ps.setObject(8, data.getUuid());
            }

            @Override
            public int getBatchSize() {
                return dataList.size();
            }
        });

    }


}




