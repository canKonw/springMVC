package com.hh.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.SqlSessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.util.List;

/**
 * Created by Administrator on 15-9-29.
 */
@Component
//@Repository
public class BaseDao {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    /**
     * 获取数据库连接对象
     *
     * @return
     */
    private Connection getConnection() {
        Connection connection = SqlSessionUtils.getSqlSession(
                sqlSessionTemplate.getSqlSessionFactory(),
                sqlSessionTemplate.getExecutorType(),
                sqlSessionTemplate.getPersistenceExceptionTranslator()).getConnection();
        return connection;
    }

    /**
     * 获得集合
     * @param statementId
     * @param parameter
     * @return
     */
    public List getList(String statementId, Object parameter){
        return sqlSessionTemplate.selectList(statementId,parameter);
    }

    public Object selectOne(String statementId, Object parameter){
        return sqlSessionTemplate.selectOne(statementId,parameter);
    }
}
