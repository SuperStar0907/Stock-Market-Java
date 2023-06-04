package org.project.model;

import com.crazzyghost.alphavantage.timeseries.response.StockUnit;
import com.crazzyghost.alphavantage.timeseries.response.TimeSeriesResponse;

import java.util.ArrayList;
import java.util.List;

public class StockUnitModel {
    private double open;
    private double high;
    private double low;
    private double close;
    private double adjustedClose;
    private long volume;
    private double dividendAmount;
    private double splitCoefficient;
    private String date;

    public StockUnitModel(StockUnit stockUnit) {
        this.open = stockUnit.getOpen();
        this.high = stockUnit.getHigh();
        this.low = stockUnit.getLow();
        this.close = stockUnit.getClose();
        this.adjustedClose = stockUnit.getAdjustedClose();
        this.volume = stockUnit.getVolume();
        this.dividendAmount = stockUnit.getDividendAmount();
        this.splitCoefficient = stockUnit.getSplitCoefficient();
        this.date = stockUnit.getDate();
    }

    // Getters and setters

    public double getOpen() {
        return open;
    }

    public void setOpen(double open) {
        this.open = open;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public double getClose() {
        return close;
    }

    public void setClose(double close) {
        this.close = close;
    }

    public double getAdjustedClose() {
        return adjustedClose;
    }

    public void setAdjustedClose(double adjustedClose) {
        this.adjustedClose = adjustedClose;
    }

    public long getVolume() {
        return volume;
    }

    public void setVolume(long volume) {
        this.volume = volume;
    }

    public double getDividendAmount() {
        return dividendAmount;
    }

    public void setDividendAmount(double dividendAmount) {
        this.dividendAmount = dividendAmount;
    }

    public double getSplitCoefficient() {
        return splitCoefficient;
    }

    public void setSplitCoefficient(double splitCoefficient) {
        this.splitCoefficient = splitCoefficient;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public static List<StockUnitModel> createFromResponse(TimeSeriesResponse response) {
        List<StockUnitModel> stockUnits = new ArrayList<>();

        for (StockUnit stockUnit : response.getStockUnits().subList(0,20)) {
            StockUnitModel model = new StockUnitModel(stockUnit);
            stockUnits.add(model);
        }

        return stockUnits;
    }
}
