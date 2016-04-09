package com.letsbuild.dao.mapper.bo;

import java.sql.Timestamp;

public class OrdOrder {
    private Long id;

    private String projectCode;

    private Long projectLeader;

    private String provinceCode;

    private String cityCode;

    private String brandCode;

    private String merchant;

    private String address;

    private String contactName;

    private String contactTel;

    private String type;

    private Double quotesAmount;

    private Double submitAmount;

    private Double completeAmount;

    private Timestamp receiveTime;

    private Timestamp submitTime;

    private Timestamp installTime;

    private String contractNo;

    private String status;

    private Timestamp statusTime;

    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode == null ? null : projectCode.trim();
    }

    public Long getProjectLeader() {
        return projectLeader;
    }

    public void setProjectLeader(Long projectLeader) {
        this.projectLeader = projectLeader;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode == null ? null : provinceCode.trim();
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    public String getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode == null ? null : brandCode.trim();
    }

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant == null ? null : merchant.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName == null ? null : contactName.trim();
    }

    public String getContactTel() {
        return contactTel;
    }

    public void setContactTel(String contactTel) {
        this.contactTel = contactTel == null ? null : contactTel.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Double getQuotesAmount() {
        return quotesAmount;
    }

    public void setQuotesAmount(Double quotesAmount) {
        this.quotesAmount = quotesAmount;
    }

    public Double getSubmitAmount() {
        return submitAmount;
    }

    public void setSubmitAmount(Double submitAmount) {
        this.submitAmount = submitAmount;
    }

    public Double getCompleteAmount() {
        return completeAmount;
    }

    public void setCompleteAmount(Double completeAmount) {
        this.completeAmount = completeAmount;
    }

    public Timestamp getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Timestamp receiveTime) {
        this.receiveTime = receiveTime;
    }

    public Timestamp getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Timestamp submitTime) {
        this.submitTime = submitTime;
    }

    public Timestamp getInstallTime() {
        return installTime;
    }

    public void setInstallTime(Timestamp installTime) {
        this.installTime = installTime;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo == null ? null : contractNo.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Timestamp getStatusTime() {
        return statusTime;
    }

    public void setStatusTime(Timestamp statusTime) {
        this.statusTime = statusTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}