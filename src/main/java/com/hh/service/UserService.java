package com.hh.service;

import com.hh.dao.UserDao;
import com.hh.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 15-9-29.
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    public List<User> getAllUser(){
        return userDao.getallUser();
    }

    public User getUserById(int id){
       return  userDao.getUserById(id);
    }
}
