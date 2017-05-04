package com.vilens.linzi.em.crm.dao;

import com.vilens.linzi.em.crm.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vilens on 2017/4/12.
 */
@Repository
public class UserDaoImpl {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    public void setSqlSession(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    public int deleteById(Long id) {
        return 0;
    }

    public int insert(User record) {
        return 0;
    }

    public User selectById(Long id) {
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("id",id);
        return sqlSessionTemplate.selectOne("com.vilens.linzi.em.crm.dao.selectById", param);
    }

    public List<User> selectAll() {
        return sqlSessionTemplate.selectList("com.vilens.linzi.em.crm.dao.selectAll");
    }

    public User findUserByUserNameAndPwd(User user){
        return sqlSessionTemplate.selectOne("com.vilens.linzi.em.crm.dao.selectUserByUserNameAndPwd",user);
    }

    public int updateById(User record) {
        return 0;
    }
}
