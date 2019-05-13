package com.lanhu.cn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/testController")
public class testController {

	@RequestMapping(value="/hello")
	public void hello(){
		System.out.println("hello world!");
	}
}
