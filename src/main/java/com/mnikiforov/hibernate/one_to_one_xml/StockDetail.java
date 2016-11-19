package com.mnikiforov.hibernate.one_to_one_xml;

import java.util.Date;

/**
 * Created by sbt-nikiforov-mo on 11/16/16.
 */
public class StockDetail {

    private Integer id;
    private Stock stock;
    private String compName;
    private String compDesc;
    private String remark;
    private Date listedDate;

    public StockDetail() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public String getCompDesc() {
        return compDesc;
    }

    public void setCompDesc(String compDesc) {
        this.compDesc = compDesc;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getListedDate() {
        return listedDate;
    }

    public void setListedDate(Date listedDate) {
        this.listedDate = listedDate;
    }

    @Override
    public String toString() {
        return "StockDetail{" +
                "id=" + id +
                ", compName='" + compName + '\'' +
                ", compDesc='" + compDesc + '\'' +
                ", remark='" + remark + '\'' +
                ", listedDate=" + listedDate +
                '}';
    }
}
