package com.letsbuild.dao.mapper.bo;

import java.sql.Timestamp;

public class OrdForegift {
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

    private Double amount;

    private Timestamp planRefundTime;

    private Timestamp createTime;

    private Timestamp payTime;

    private String payMode;

    private Long payUser;

    private String withReceipt;

    private Double cutAmount;

    private Double unableAmount;

    private Timestamp refundTime;

    private String status;

    private Timestamp statusTime;

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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Timestamp getPlanRefundTime() {
        return planRefundTime;
    }

    public void setPlanRefundTime(Timestamp planRefundTime) {
        this.planRefundTime = planRefundTime;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getPayTime() {
        return payTime;
    }

    public void setPayTime(Timestamp payTime) {
        this.payTime = payTime;
    }

    public String getPayMode() {
        return payMode;
    }

    public void setPayMode(String payMode) {
        this.payMode = payMode == null ? null : payMode.trim();
    }

    public Long getPayUser() {
        return payUser;
    }

    public void setPayUser(Long payUser) {
        this.payUser = payUser;
    }

    public String getWithReceipt() {
        return withReceipt;
    }

    public void setWithReceipt(String withReceipt) {
        this.withReceipt = withReceipt == null ? null : withReceipt.trim();
    }

    public Double getCutAmount() {
        return cutAmount;
    }

    public void setCutAmount(Double cutAmount) {
        this.cutAmount = cutAmount;
    }

    public Double getUnableAmount() {
        return unableAmount;
    }

    public void setUnableAmount(Double unableAmount) {
        this.unableAmount = unableAmount;
    }

    public Timestamp getRefundTime() {
        return refundTime;
    }

    public void setRefundTime(Timestamp refundTime) {
        this.refundTime = refundTime;
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
}