package com.vilens.linzi.em.crm.controller;

import com.alibaba.fastjson.JSON;
import com.vilens.linzi.em.crm.base.Constant;
import com.vilens.linzi.em.crm.bean.JsonRequestBody;
import com.vilens.linzi.em.crm.dao.ReportDaoImpl;
import com.vilens.linzi.em.crm.security.IgnoreSecurity;
import com.vilens.linzi.em.crm.utils.ExcelUtil;
import com.vilens.linzi.em.crm.utils.StringUtil;
import com.vilens.linzi.em.crm.utils.TimeUtil;
import org.apache.http.entity.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * Created by vilens on 2017/6/1.
 */
@RestController
@RequestMapping("/rest/export/")
public class ExportController {

    @Autowired
    ReportDaoImpl reportDao;

    @RequestMapping("/exportProjectData")
    @IgnoreSecurity
    public void exportProjectData(String param, HttpServletResponse response) throws Exception {
        response.setCharacterEncoding("utf-8");
        response.setContentType(ContentType.APPLICATION_OCTET_STREAM.getMimeType());
        String fileName = TimeUtil.format() + ".xlsx";
        response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);

        try {
            JsonRequestBody jsonRequestBody = JSON.parseObject(param, JsonRequestBody.class);
            Long beginTime = jsonRequestBody.getLong("beginTime");
            Long endTime = jsonRequestBody.getLong("endTime");
            String projectName = jsonRequestBody.getString("projectName");
            String ownName = jsonRequestBody.getString("ownName");
            String mainContractCode = jsonRequestBody.getString("mainContractCode");
            String subContractCode1 = jsonRequestBody.getString("subContractCode1");
            String subContractCode2 = jsonRequestBody.getString("subContractCode2");

            Map<String, Object> param_ = new HashMap();
            if (beginTime != null) {
                param_.put("beginTime", new Date(beginTime));
            }
            if (endTime != null) {
                param_.put("endTime", new Date(endTime));
            }
            if (StringUtil.isNotEmpty(projectName)) {
                param_.put("projectName", projectName);
            }
            if (StringUtil.isNotEmpty(ownName)) {
                param_.put("ownName", ownName);
            }
            if (StringUtil.isNotEmpty(mainContractCode)) {
                param_.put("mainContractCode", mainContractCode);
            }
            if (StringUtil.isNotEmpty(subContractCode1)) {
                param_.put("subContractCode1", subContractCode1);
            }
            if (StringUtil.isNotEmpty(subContractCode2)) {
                param_.put("subContractCode2", subContractCode2);
            }

            List<Map<String, Object>> dataList = reportDao.selectReportByDate(param_);
            ExcelUtil.exportExcel(null, response.getOutputStream(), dataList, Constant.EXCEL_TITLE_TOTAL_LIST, "总表");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
