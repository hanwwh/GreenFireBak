package com.greenfire.db.mybatis.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.greenfire.db.mybatis.dao.IUserDAO;
import com.greenfire.db.mybatis.pojo.User;
import com.greenfire.db.mybatis.service.interfaces.IUserService;
import org.springframework.stereotype.Service;

/**
 * Created by YUHB on 2016/4/30.
 */
@Service("userService")
public class UserServiceImpl implements IUserService {
    @Resource
    private IUserDAO userDAO;

    public User getUserById(int userId) {
        return this.userDAO.selectByPrimaryKey(userId);
    }

	public List<User> selectUsers() {
		// TODO Auto-generated method stub
		return this.userDAO.selectUsers();
	}
}
