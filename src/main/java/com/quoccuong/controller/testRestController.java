package com.quoccuong.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class testRestController {
	@GetMapping("/hello/{param}")
	@ResponseBody
	public String sayHello(@PathVariable("param") String param)
	{
		return "Hello "+param;
	}
}
