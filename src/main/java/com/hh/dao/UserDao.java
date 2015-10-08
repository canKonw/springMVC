package com.hh.dao;

import com.hh.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 15-9-29.
 */
@Repository
public class UserDao  extends  BaseDao{

    public List<User> getallUser(){
        return this.getList("UserMapper.getAllUser",null);
    }

    public User getUserById(int id){
        return (User)this.selectOne("UserMapper.getUserById",id);
    }
}
