package com.greenfire.db.mybatis.dao;

import java.util.List;

import com.greenfire.db.mybatis.pojo.User;

public interface IUserDAO {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);
    
    List<User> selectUsers();

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}