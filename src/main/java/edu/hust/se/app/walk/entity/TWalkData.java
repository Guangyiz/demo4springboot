package edu.hust.se.app.walk.entity;

import java.io.Serializable;

/**
 * (TWalkData)实体类
 *
 * @author makejava
 * @since 2020-04-25 14:56:15
 */
public class TWalkData implements Serializable {
    private static final long serialVersionUID = -30756715520996439L;
    
    private Integer id;
    
    private String openid;
    
    private Integer year;
    
    private Integer month;
    
    private Integer kdate;
    
    private Integer steps;
    
    private Double kms;
    
    private Double caloris;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getKdate() {
        return kdate;
    }

    public void setKdate(Integer kdate) {
        this.kdate = kdate;
    }

    public Integer getSteps() {
        return steps;
    }

    public void setSteps(Integer steps) {
        this.steps = steps;
    }

    public Double getKms() {
        return kms;
    }

    public void setKms(Double kms) {
        this.kms = kms;
    }

    public Double getCaloris() {
        return caloris;
    }

    public void setCaloris(Double caloris) {
        this.caloris = caloris;
    }

}