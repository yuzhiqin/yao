package com.shu.yao.controller;

import com.shu.yao.annotation.YaoController;
import com.shu.yao.annotation.YaoRequestMapping;


@YaoController("/userLogin")
public class LoginController {

	@YaoRequestMapping("login")
	public void login(){
		
		System.out.println("----------我已登录家里--------------");
	}
}
