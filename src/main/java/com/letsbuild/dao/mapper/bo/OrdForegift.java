package com.letsbuild.dao.mapper.bo;

import java.sql.Timestamp;

public class OrdForegift {
    private Long id;

    private Long orderId;

    private Double amount;

    private Timestamp planReturnTime;

    private Timestamp createTime;

    private Timestamp payTime;

    private String payMode;

    private Long payUser;

    private String withReceipt;

    private Double cutAmount;

    private Double unableAmount;

    private Timestamp backTime;

    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Timestamp getPlanReturnTime() {
        return planReturnTime;
    }

    public void setPlanReturnTime(Timestamp planReturnTime) {
        this.planReturnTime = planReturnTime;
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

    public Timestamp getBackTime() {
        return backTime;
    }

    public void setBackTime(Timestamp backTime) {
        this.backTime = backTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}