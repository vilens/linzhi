package com.vilens.linzi.em.crm.pojo;

import java.io.Serializable;

/**
 * Created by vilens on 2017/4/15.
 */
public class ProjectDetail implements Serializable{

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String projectAccount;
    private String projectName;
    private Integer busbarBridge;
    private Integer cableBridge;
    private String ownName;
    private String status;
    private String datasStatus;
    private String auditStatus;
    private String invoiceStatus;
    private Double billingVal;
    private String receivedPaymentsStatus;
    private Double receivedPaymentsVal;
    private Double totalPayAmount;
    private String remark;
    private Integer contractId;
    private String contractCode;
    private String contractVal;
    private String contractStatus;
    private String contractConfirm;
    private String payVal;
    private Integer isMain;
    private Integer ownerId;
    private Integer pId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjectAccount() {
        return projectAccount;
    }

    public void setProjectAccount(String projectAccount) {
        this.projectAccount = projectAccount;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Integer getBusbarBridge() {
        return busbarBridge;
    }

    public void setBusbarBridge(Integer busbarBridge) {
        this.busbarBridge = busbarBridge;
    }

    public Integer getCableBridge() {
        return cableBridge;
    }

    public void setCableBridge(Integer cableBridge) {
        this.cableBridge = cableBridge;
    }

    public String getOwnName() {
        return ownName;
    }

    public void setOwnName(String ownName) {
        this.ownName = ownName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDatasStatus() {
        return datasStatus;
    }

    public void setDatasStatus(String datasStatus) {
        this.datasStatus = datasStatus;
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getInvoiceStatus() {
        return invoiceStatus;
    }

    public void setInvoiceStatus(String invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
    }

    public Double getBillingVal() {
        return billingVal;
    }

    public void setBillingVal(Double billingVal) {
        this.billingVal = billingVal;
    }

    public String getReceivedPaymentsStatus() {
        return receivedPaymentsStatus;
    }

    public void setReceivedPaymentsStatus(String receivedPaymentsStatus) {
        this.receivedPaymentsStatus = receivedPaymentsStatus;
    }

    public Double getReceivedPaymentsVal() {
        return receivedPaymentsVal;
    }

    public void setReceivedPaymentsVal(Double receivedPaymentsVal) {
        this.receivedPaymentsVal = receivedPaymentsVal;
    }

    public Double getTotalPayAmount() {
        return totalPayAmount;
    }

    public void setTotalPayAmount(Double totalPayAmount) {
        this.totalPayAmount = totalPayAmount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public String getContractVal() {
        return contractVal;
    }

    public void setContractVal(String contractVal) {
        this.contractVal = contractVal;
    }

    public String getContractStatus() {
        return contractStatus;
    }

    public void setContractStatus(String contractStatus) {
        this.contractStatus = contractStatus;
    }

    public String getContractConfirm() {
        return contractConfirm;
    }

    public void setContractConfirm(String contractConfirm) {
        this.contractConfirm = contractConfirm;
    }

    public String getPayVal() {
        return payVal;
    }

    public void setPayVal(String payVal) {
        this.payVal = payVal;
    }

    public Integer getIsMain() {
        return isMain;
    }

    public void setIsMain(Integer isMain) {
        this.isMain = isMain;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }
}
