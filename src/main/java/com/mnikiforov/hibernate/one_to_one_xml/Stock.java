package com.mnikiforov.hibernate.one_to_one_xml;

/**
 * Created by sbt-nikiforov-mo on 11/16/16.
 */
public class Stock {

    private Integer id;
    private String stockCode;
    private String stockName;
    private StockDetail stockDetail;

    public Stock() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public StockDetail getStockDetail() {
        return stockDetail;
    }

    public void setStockDetail(StockDetail stockDetail) {
        this.stockDetail = stockDetail;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", stockCode='" + stockCode + '\'' +
                ", stockName='" + stockName + '\'' +
                ", stockDetail=" + stockDetail +
                '}';
    }
}
