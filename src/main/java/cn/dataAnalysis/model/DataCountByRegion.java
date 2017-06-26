package cn.dataAnalysis.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by feng on 2017/4/6.
 */
public class DataCountByRegion extends BaseEntity{


    private static final long serialVersionUID = 1L;

    private Integer id;

    private String regionCode;

    private Date captureTime;

    private Long number;

    private Double averageTotalPrice;

    private Double averagePerPrice;

    private String regionName;

    private Long attentionNumber;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public Date getCaptureTime() {
        return captureTime;
    }

    public void setCaptureTime(Date captureTime) {
        this.captureTime = captureTime;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Double getAverageTotalPrice() {
        return averageTotalPrice;
    }

    public void setAverageTotalPrice(Double averageTotalPrice) {
        this.averageTotalPrice = averageTotalPrice;
    }

    public Double getAveragePerPrice() {
        return averagePerPrice;
    }

    public void setAveragePerPrice(Double averagePerPrice) {
        this.averagePerPrice = averagePerPrice;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public Long getAttentionNumber() {
        return attentionNumber;
    }

    public void setAttentionNumber(Long attentionNumber) {
        this.attentionNumber = attentionNumber;
    }
}
