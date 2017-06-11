package com.vilens.linzi.em.crm.bean;

import com.google.common.collect.Lists;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by vilens on 2017/6/4.
 */
public class DataPaging<E> implements Serializable {
    private static final long serialVersionUID = 1L;
    private PageForm pageForm;
    private List<E> list;

    public DataPaging() {
    }

    public DataPaging(PageForm pageForm, List<E> list) {
        this.pageForm = pageForm;
        this.list = list;
    }

    public DataPaging(List<E> list, Integer total) {
        if (total != null) {
            this.pageForm = new PageForm(total);
        } else {
            this.pageForm = new PageForm(0);
        }
        pageForm.setCurrPage(Long.valueOf(1));
        this.list = list;
    }

    public DataPaging(List<E> list, Integer total, Long currPage) {
        if (total != null) {
            this.pageForm = new PageForm(total);
        } else {
            this.pageForm = new PageForm(0);
        }
        if (currPage != null) {
            pageForm.setCurrPage(currPage);
        } else {
            pageForm.setCurrPage(Long.valueOf(1));
        }

        this.list = list;
    }

    public List<E> getList() {
        return this.list;
    }

    public Long getTotal() {
        return pageForm.getTotal();
    }

    public Long getTotalPage() {
        return pageForm.getTotalPage();
    }

    public Long getCurrPage() {
        return pageForm.getCurrPage();
    }

    public Long getStart() {
        return pageForm.getStart();
    }

    public Long getLimit() {
        return pageForm.getLimit();
    }

}
