package com.vilens.linzi.em.crm.controller;

import com.vilens.linzi.em.crm.bean.JsonRequestBody;
import com.vilens.linzi.em.crm.bean.ResultForm;
import com.vilens.linzi.em.crm.dao.BaseDaoImpl;
import com.vilens.linzi.em.crm.dao.UserDaoImpl;
import com.vilens.linzi.em.crm.entity.Contract;
import com.vilens.linzi.em.crm.entity.Project;
import com.vilens.linzi.em.crm.entity.User;
import com.vilens.linzi.em.crm.pojo.ProjectDetail;
import com.vilens.linzi.em.crm.security.IgnoreSecurity;
import com.vilens.linzi.em.crm.security.TokenManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vilens on 2017/4/12.
 */
@RestController
@RequestMapping("/rest/commonData/")
public class CommonDataController {
    private static Logger logger = LoggerFactory.getLogger(CommonDataController.class);

    @Autowired
    UserDaoImpl userDao;

    @Autowired
    BaseDaoImpl baseDao;

    @Autowired
    private TokenManager tokenManager;

    @IgnoreSecurity
    @RequestMapping(value = "/login")
    public Object login(@RequestBody JsonRequestBody jsonRequestBody) {
        ResultForm<?> result = null;
        String userName = jsonRequestBody.getString("userName");
        String password = jsonRequestBody.getString("password");
        if (userName != null && !"".equals(userName.trim())
                && password != null && !"".equals(password.trim())) {
            User paramUser = new User();
            paramUser.setUserName(userName);
            paramUser.setPassword(password);
            try {
                User user = userDao.findUserByUserNameAndPwd(paramUser);
                if (user != null) {
                    String token = tokenManager.createToken(userName);
                    result = ResultForm.createSuccessResultForm(token, "查询成功");
                } else {
                    result = ResultForm.createErrorResultForm(null, "用户不存在！");
                }
            } catch (Exception e) {
                logger.error("error {} ", e.getMessage());
                result = ResultForm.createErrorResultForm(null, e.getMessage());
                e.printStackTrace();
            }
        } else {
            result = ResultForm.createErrorResultForm(null, "用户名或者密码不可为空！");
        }

        return result;
    }

    // 获取监管级别；
//    @RequestMapping(value = "/getUsersById",method = RequestMethod.POST)
    @RequestMapping(value = "/getUsers")
    public Object getUser(@RequestBody JsonRequestBody jsonRequestBody) {
        ResultForm<?> result = null;

        try {
            List<User> users = userDao.selectAll();
            result = ResultForm.createSuccessResultForm(users, "查询成功");
        } catch (Exception e) {
            logger.error("error {} ", e.getMessage());
            result = ResultForm.createErrorResultForm(null, e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping(value = "/createProject")
    public Object createProject(@RequestBody JsonRequestBody jsonRequestBody) {
        ResultForm<?> result = null;
        String projectAccount = jsonRequestBody.getString("projectAccount");
        String projectName = jsonRequestBody.getString("projectName");
        try {
            Project project = new Project();
            project.setProjectAccount(projectAccount);
            project.setProjectName(projectName);
            int id = baseDao.createProject(project);
            project.setId(id);
            if (id > 0) {
                baseDao.createContract(id, 1);
                baseDao.createContract(id);
                baseDao.createContract(id);
            }
            result = ResultForm.createSuccessResultForm(project, "查询成功");
        } catch (Exception e) {
            logger.error("error {} ", e.getMessage());
            result = ResultForm.createErrorResultForm(null, e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping(value = "/getProjectList")
    public Object getProjectList(@RequestBody JsonRequestBody jsonRequestBody) {
        ResultForm<?> result = null;
//        String projectAccount = jsonRequestBody.getString("projectAccount");
//        String projectName = jsonRequestBody.getString("projectName");
        try {
            List<ProjectDetail> projectList = baseDao.getProjectList();
            result = ResultForm.createSuccessResultForm(projectList, "查询成功");
        } catch (Exception e) {
            logger.error("error {} ", e.getMessage());
            result = ResultForm.createErrorResultForm(null, e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping(value = "/getProjectById")
    public Object getProjectById(@RequestBody JsonRequestBody jsonRequestBody) {
        ResultForm<?> result = null;
        String projectId = jsonRequestBody.getString("projectId");
        if (projectId != null && !"".equals(projectId.trim())) {
            try {
                Map param = new HashMap();
                param.put("projectId", Integer.valueOf(projectId).intValue());
                ProjectDetail projectDetail = baseDao.getProjectById(param);
                result = ResultForm.createSuccessResultForm(projectDetail, "查询成功");
            } catch (Exception e) {
                logger.error("error {} ", e.getMessage());
                result = ResultForm.createErrorResultForm(null, e.getMessage());
                e.printStackTrace();
            }
        } else {
            result = ResultForm.createErrorResultForm(null, "项目id不可为空！");
        }
        return result;
    }

    @RequestMapping(value = "/getSubContractListByProjectId")
    public Object getSubContractListByProjectId(@RequestBody JsonRequestBody jsonRequestBody) {
        ResultForm<?> result = null;
        String projectId = jsonRequestBody.getString("projectId");
        if (projectId != null && !"".equals(projectId.trim())) {
            try {
                Map param = new HashMap();
                param.put("projectId", Integer.valueOf(projectId).intValue());
                List subContractList = baseDao.getSubContractListByProjectId(param);
                result = ResultForm.createSuccessResultForm(subContractList, "查询成功");
            } catch (Exception e) {
                logger.error("error {} ", e.getMessage());
                result = ResultForm.createErrorResultForm(null, e.getMessage());
                e.printStackTrace();
            }
        } else {
            result = ResultForm.createErrorResultForm(null, "项目id不可为空！");
        }

        return result;
    }

    @RequestMapping(value = "/updateProject")
    public Object updateProject(@RequestBody JsonRequestBody jsonRequestBody) {
        ResultForm<?> result = null;
        String id = jsonRequestBody.getString("id");
        Contract subContractor1 = jsonRequestBody.getObject("subContractor1", Contract.class);
        Contract subContractor2 = jsonRequestBody.getObject("subContractor2", Contract.class);
        if (id != null && !"".equals(id.trim())) {
            try {
                ProjectDetail projectDetail = (ProjectDetail) JsonRequestBody.toJavaObject(jsonRequestBody, ProjectDetail.class);
                baseDao.updateProjectDetailById(projectDetail);
                if (subContractor1 != null && subContractor1.getId() != null) {
                    baseDao.updateContractById(subContractor1);
                }
                if (subContractor2 != null && subContractor2.getId() != null) {
                    baseDao.updateContractById(subContractor2);
                }
                result = ResultForm.createSuccessResultForm("更新成功");
            } catch (Exception e) {
                logger.error("error {} ", e.getMessage());
                result = ResultForm.createErrorResultForm(null, e.getMessage());
                e.printStackTrace();
            }
        } else {
            result = ResultForm.createErrorResultForm(null, "项目id不可为空！");
        }

        return result;
    }

}
