package com.greenfire.db.mybatis.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.greenfire.db.mybatis.pojo.User;
import com.greenfire.db.mybatis.service.interfaces.IUserService;

@Controller
@RequestMapping("/test")
public class TestUserController {

	@Resource
	private IUserService userService;
	
	@RequestMapping("/userInfo")
	public String dispatchUserInfo(){
		System.out.println("---------->userInfo");
		return "/test/userInfo";
	}
	
	@RequestMapping("/getUser")
	public void getUsers(HttpServletRequest request, HttpServletResponse response, Model model) {
		List<User> users = userService.selectUsers();
		System.out.println("----->user count: "+users.size());
		String jsonUsers = JSON.toJSONString(users);
		System.out.println("----->jsonUsers: "+jsonUsers);
		String result = "{\"total\":"+users.size()+",\"rows\":"+jsonUsers+"}";
		System.out.println("----->result: "+result);
		
		PrintWriter writer = null;
		try {
			
			response.setCharacterEncoding("UTF-8");
			writer = response.getWriter();
			writer.write(jsonUsers);
			writer.flush();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (writer != null) {
				writer.close();
			}
		}
		
		//return result;
	}
}
