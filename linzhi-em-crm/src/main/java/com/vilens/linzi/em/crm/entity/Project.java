package com.vilens.linzi.em.crm.entity;

import com.vilens.linzi.em.crm.pojo.ProjectDetail;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by vilens on 2017/4/15.
 */
public class Project implements Serializable{
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

    private Contract mainContract;
    private ArrayList<Contract> subContractList;

    public Project(){}

    public Project(ProjectDetail projectDetail) {
        this.projectAccount = projectDetail.getProjectAccount();
        this.projectName = projectDetail.getProjectName();
        this.busbarBridge = projectDetail.getBusbarBridge();
        this.cableBridge = projectDetail.getCableBridge();
        this.ownName = projectDetail.getOwnName();
        this.status = projectDetail.getStatus();
        this.datasStatus = projectDetail.getDatasStatus();
        this.auditStatus = projectDetail.getAuditStatus();
        this.invoiceStatus = projectDetail.getInvoiceStatus();
        this.billingVal = projectDetail.getBillingVal();
        this.receivedPaymentsStatus = projectDetail.getReceivedPaymentsStatus();
        this.receivedPaymentsVal = projectDetail.getReceivedPaymentsVal();
        this.totalPayAmount = projectDetail.getTotalPayAmount();
        this.remark = projectDetail.getRemark();

        mainContract = new Contract();
        mainContract.setId(projectDetail.getContractId());
        mainContract.setContractCode(projectDetail.getContractCode());
        mainContract.setContractConfirm(projectDetail.getContractConfirm());
        mainContract.setContractVal(projectDetail.getContractVal());
        mainContract.setIsMain(1);
        mainContract.setStatus(projectDetail.getContractStatus());
        mainContract.setPayVal(projectDetail.getPayVal());
        mainContract.setOwnerId(projectDetail.getOwnerId());
        mainContract.setpId(projectDetail.getpId());
    }

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

    public Contract getMainContract() {
        return mainContract;
    }

    public void setMainContract(Contract mainContract) {
        this.mainContract = mainContract;
    }

    public ArrayList<Contract> getSubContractList() {
        return subContractList;
    }

    public void setSubContractList(ArrayList<Contract> subContractList) {
        this.subContractList = subContractList;
    }
}
