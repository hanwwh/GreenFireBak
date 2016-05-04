package com.greenfire.db.mybatis.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.greenfire.db.mybatis.pojo.User;
import com.greenfire.db.mybatis.service.interfaces.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	private IUserService userService;
	
	@RequestMapping(value = "/showUser", method = RequestMethod.GET)
	public String toIndex(HttpServletRequest request,Model model){
		int userId = Integer.parseInt(request.getParameter("id"));
		System.out.println("------------>id: "+userId);
	    User user = this.userService.getUserById(userId);
	    model.addAttribute("user", user);
	    model.addAttribute("name", "yuhb");
	    System.out.println("------------>name: "+user.getUserName());
	    return "/test/showUser";
	}
	
	@RequestMapping("/param/{id}")
	public String processParam(@RequestBody @PathVariable String id, Model model){
		System.out.println("processParam------------>id: "+id);
		return "hello";
	}
}
