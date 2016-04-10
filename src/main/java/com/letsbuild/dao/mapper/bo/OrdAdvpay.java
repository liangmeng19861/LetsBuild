package com.letsbuild.dao.mapper.bo;

import java.sql.Timestamp;

public class OrdAdvpay {
    private Long id;

    private String projectCode;

    private Long projectLeader;

    private String provinceCode;

    private String cityCode;

    private String brandCode;

    private String merchant;

    private String address;

    private String contactName2;

    private String contactTel2;

    private Double amount;

    private String accountNo;

    private String accountName;

    private String openBank;

    private String contactName;

    private String contactTel;

    private Timestamp planReturnTime;

    private Timestamp payTime;

    private Long payUser;

    private Double payAmount;

    private String status;

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

    public String getContactName2() {
        return contactName2;
    }

    public void setContactName2(String contactName2) {
        this.contactName2 = contactName2 == null ? null : contactName2.trim();
    }

    public String getContactTel2() {
        return contactTel2;
    }

    public void setContactTel2(String contactTel2) {
        this.contactTel2 = contactTel2 == null ? null : contactTel2.trim();
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo == null ? null : accountNo.trim();
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName == null ? null : accountName.trim();
    }

    public String getOpenBank() {
        return openBank;
    }

    public void setOpenBank(String openBank) {
        this.openBank = openBank == null ? null : openBank.trim();
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

    public Timestamp getPlanReturnTime() {
        return planReturnTime;
    }

    public void setPlanReturnTime(Timestamp planReturnTime) {
        this.planReturnTime = planReturnTime;
    }

    public Timestamp getPayTime() {
        return payTime;
    }

    public void setPayTime(Timestamp payTime) {
        this.payTime = payTime;
    }

    public Long getPayUser() {
        return payUser;
    }

    public void setPayUser(Long payUser) {
        this.payUser = payUser;
    }

    public Double getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(Double payAmount) {
        this.payAmount = payAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}