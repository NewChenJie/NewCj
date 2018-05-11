package com.cj.domain.oamysql;

import java.util.Date;

public class AliNewCustomer {
    private Integer id;

    private String company;

    private String originUrl;

    private String aliUrl;

    private String gmtIdentification;

    private String address;

    private String industry;

    private String mianbusiness;

    private String gmtGet;

    private Date gmtCreate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public String getOriginUrl() {
        return originUrl;
    }

    public void setOriginUrl(String originUrl) {
        this.originUrl = originUrl == null ? null : originUrl.trim();
    }

    public String getAliUrl() {
        return aliUrl;
    }

    public void setAliUrl(String aliUrl) {
        this.aliUrl = aliUrl == null ? null : aliUrl.trim();
    }

    public String getGmtIdentification() {
        return gmtIdentification;
    }

    public void setGmtIdentification(String gmtIdentification) {
        this.gmtIdentification = gmtIdentification == null ? null : gmtIdentification.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry == null ? null : industry.trim();
    }

    public String getMianbusiness() {
        return mianbusiness;
    }

    public void setMianbusiness(String mianbusiness) {
        this.mianbusiness = mianbusiness == null ? null : mianbusiness.trim();
    }

    public String getGmtGet() {
        return gmtGet;
    }

    public void setGmtGet(String gmtGet) {
        this.gmtGet = gmtGet == null ? null : gmtGet.trim();
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }
}