package com.vilens.linzi.em.crm.bean;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;

/**
 * Created by vilens on 2017/4/12.
 */
public class JsonRequestBody extends JSONObject {

    private static final long serialVersionUID = 1L;

    private PageForm pageForm;

    public <T> T tryGet(String name, Class<T> clazz) {
        return StringUtils.isNotBlank(name) && this.containsKey(name)? JSON.toJavaObject(this.getJSONObject(name), clazz):JSON.toJavaObject(this, clazz);
    }

    public PageForm getPageForm() {
        if(this.pageForm == null) {
            this.pageForm = (PageForm)this.tryGet("pageForm", PageForm.class);
        }

        return this.pageForm;
    }
}
