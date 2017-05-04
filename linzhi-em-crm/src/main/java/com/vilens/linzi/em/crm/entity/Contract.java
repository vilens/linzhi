package com.vilens.linzi.em.crm.entity;

import java.io.Serializable;

/**
 * Created by vilens on 2017/4/15.
 */
public class Contract implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String contractCode;
    private String contractVal;
    private String status;
    private String contractConfirm;
    private String payVal;
    private Integer isMain;
    private Integer ownerId;
    private Integer pId;

    private Contractor contractor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Contractor getContractor() {
        return contractor;
    }

    public void setContractor(Contractor contractor) {
        this.contractor = contractor;
    }
}
