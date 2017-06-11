package com.vilens.linzi.em.crm.bean;

import com.google.common.collect.Lists;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.vilens.linzi.em.crm.utils.MapUtil;
import com.vilens.linzi.em.crm.utils.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;

/**
 * Created by vilens on 2017/6/4.
 */
public class PageForm implements IBaseForm {
    private static final long serialVersionUID = 1L;
    private long currPage = 1;
    private long limit = 10;
    private long total;
    private long totalPage;

    public PageForm() {
    }

    public PageForm(long total) {
        this.total = total;
        if (this.total % this.limit == 0) {
            this.totalPage = this.total / this.limit;
        } else if (this.total < this.limit) {
            this.totalPage = 1;
        } else {
            this.totalPage = this.total / this.limit + 1;
        }
    }

    public Long getStart() {
        return (this.currPage - 1) * this.limit;
    }

    public Long getLimit() {
        return limit;
    }

    public void setLimit(Long limit) {
        this.limit = limit;
    }

    public Long getCurrPage() {
        return currPage;
    }

    public void setCurrPage(Long currPage) {
        this.currPage = currPage;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Long totalPage) {
        this.totalPage = totalPage;
    }
}
