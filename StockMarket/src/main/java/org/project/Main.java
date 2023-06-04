package org.project;

import com.crazzyghost.alphavantage.AlphaVantage;
import com.crazzyghost.alphavantage.Config;
import com.crazzyghost.alphavantage.parameters.Interval;
import com.crazzyghost.alphavantage.parameters.OutputSize;
import com.crazzyghost.alphavantage.timeseries.response.TimeSeriesResponse;
import org.project.model.StockUnitModel;

import java.util.List;

public class Main {
    private static String apiKey = "9N9EVAVUFOBOR4QZ";

    public static void main(String[] args) {
        String[] symbols = {"AAPL", "GOOGL", "AMZN", "MSFT", "FB", "TSLA", "NVDA", "JPM", "V", "JNJ", "WMT", "UNH", "BAC", "MA", "HD", "PG", "DIS", "VZ", "PYPL", "ADBE"};

        // configuration
        Config cfg = Config.builder()
                .key(apiKey)
                .timeOut(10)
                .build();
        AlphaVantage.api().init(cfg);

        //basic usage
        AlphaVantage.api()
                .timeSeries()
                .intraday()
                .forSymbol("IBM")
                .interval(Interval.FIVE_MIN)
                .outputSize(OutputSize.COMPACT)
                .onSuccess(response -> {
                    List<StockUnitModel> stockUnitModels = StockUnitModel.createFromResponse((TimeSeriesResponse) response);
                    for (StockUnitModel model : stockUnitModels) {
                        System.out.println("DateTime: " + model.getDate());
                        System.out.println("Open: " + model.getOpen());
                        System.out.println("High: " + model.getHigh());
                        System.out.println("Low: " + model.getLow());
                        System.out.println("Close: " + model.getClose());
                        System.out.println("Volume: " + model.getVolume());
                        System.out.println();
                    }
                })
                .fetch();



    }
}