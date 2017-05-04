package com.vilens.linzi.em.crm.entity;

import java.io.Serializable;

/**
 * Created by vilens on 2017/4/15.
 */
public class Contractor implements Serializable{
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String contractorName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContractorName() {
        return contractorName;
    }

    public void setContractorName(String contractorName) {
        this.contractorName = contractorName;
    }
}
