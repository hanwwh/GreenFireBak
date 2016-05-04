package com.greenfire.test;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.greenfire.db.mybatis.pojo.User;
import com.greenfire.db.mybatis.service.interfaces.IUserService;

/**
 * Created by YUHB on 2016/4/30.
 */
@RunWith(SpringJUnit4ClassRunner.class)//表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})

public class TestMyBatis {
	private static Logger logger = Logger.getLogger(TestMyBatis.class);
	
	@Resource
	private IUserService userService = null;
	
	@Test
	public void test(){
		User user = userService.getUserById(1);
		logger.info(JSON.toJSONString(user));
	}
}
