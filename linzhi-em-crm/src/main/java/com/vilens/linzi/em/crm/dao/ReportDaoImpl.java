package com.vilens.linzi.em.crm.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vilens on 2017/6/2.
 */
@Repository
public class ReportDaoImpl{

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    public void setSqlSession(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    public List selectReportByDate(Map param){
        return sqlSessionTemplate.selectList("com.vilens.linzi.em.crm.dao.reportMapper.selectReportByDate",param);
    }
}
