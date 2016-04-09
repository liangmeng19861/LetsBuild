package com.letsbuild.dao.mapper.bo;

import java.sql.Timestamp;

public class OrdStage {
    private Long id;

    private Long orderId;

    private Integer stageNo;

    private Double planAmount;

    private Timestamp planIncomeTime;

    private Double invoiceAmount;

    private Timestamp invoiceTime;

    private String invoiceNo;

    private Double incomeAmount;

    private Timestamp incomeTime;

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

    public Integer getStageNo() {
        return stageNo;
    }

    public void setStageNo(Integer stageNo) {
        this.stageNo = stageNo;
    }

    public Double getPlanAmount() {
        return planAmount;
    }

    public void setPlanAmount(Double planAmount) {
        this.planAmount = planAmount;
    }

    public Timestamp getPlanIncomeTime() {
        return planIncomeTime;
    }

    public void setPlanIncomeTime(Timestamp planIncomeTime) {
        this.planIncomeTime = planIncomeTime;
    }

    public Double getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(Double invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    public Timestamp getInvoiceTime() {
        return invoiceTime;
    }

    public void setInvoiceTime(Timestamp invoiceTime) {
        this.invoiceTime = invoiceTime;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo == null ? null : invoiceNo.trim();
    }

    public Double getIncomeAmount() {
        return incomeAmount;
    }

    public void setIncomeAmount(Double incomeAmount) {
        this.incomeAmount = incomeAmount;
    }

    public Timestamp getIncomeTime() {
        return incomeTime;
    }

    public void setIncomeTime(Timestamp incomeTime) {
        this.incomeTime = incomeTime;
    }
}