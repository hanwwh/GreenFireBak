package com.greenfire.db.mybatis.service.interfaces;

import java.util.List;

import com.greenfire.db.mybatis.pojo.User;

/**
 * Created by YUHB on 2016/4/30.
 */
public interface IUserService {
    public User getUserById(int userId);
    
    public List<User> selectUsers();
}
