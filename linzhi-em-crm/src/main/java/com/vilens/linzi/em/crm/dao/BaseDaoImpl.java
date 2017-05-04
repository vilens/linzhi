package com.vilens.linzi.em.crm.dao;

import com.vilens.linzi.em.crm.entity.Contract;
import com.vilens.linzi.em.crm.entity.Project;
import com.vilens.linzi.em.crm.pojo.ProjectDetail;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vilens on 2017/4/15.
 */
@Repository
public class BaseDaoImpl {
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    public void setSqlSession(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    public int createProject(Project project){
        int result = 0;
        result = sqlSessionTemplate.insert("com.vilens.linzi.em.crm.dao.createProject",project);
        return result == 1?project.getId():result;
    }

    public int createContract(int projectId){
        return createContract(projectId,0);
    }

    public int createContract(int projectId,int isMain){
        Map param = new HashMap();
        param.put("projectId",projectId);
        param.put("isMain",isMain);
        return sqlSessionTemplate.insert("com.vilens.linzi.em.crm.dao.createContract",param);
    }

    public List<ProjectDetail> getProjectList(){
        return getProjectList(null);
    }

    public List<ProjectDetail> getProjectList(Map param){
        return sqlSessionTemplate.selectList("com.vilens.linzi.em.crm.dao.selectProjectList",param);
    }

    public ProjectDetail getProjectById(Map param){
        return sqlSessionTemplate.selectOne("com.vilens.linzi.em.crm.dao.selectProjectById",param);
    }

    public List getSubContractListByProjectId(Map param){
        return sqlSessionTemplate.selectList("com.vilens.linzi.em.crm.dao.selectSubContractListByProjectId",param);
    }

    public int updateProjectDetailById(ProjectDetail projectDetail){
        return sqlSessionTemplate.update("com.vilens.linzi.em.crm.dao.updateProjectById",projectDetail);
    }

    public int updateContractById(Contract contract){
        return sqlSessionTemplate.update("com.vilens.linzi.em.crm.dao.updateContractById",contract);
    }
}
