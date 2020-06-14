package com.shu.yao.controller;

import com.shu.yao.annotation.YaoController;
import com.shu.yao.annotation.YaoRequestMapping;

@YaoController("/userIndex")
public class IndexController {

	@YaoRequestMapping("index")
	public void index(){
	 
		
		System.out.println("----------这是首页");
	}
	
	
}
