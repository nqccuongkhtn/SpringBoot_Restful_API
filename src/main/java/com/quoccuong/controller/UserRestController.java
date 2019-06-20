package com.quoccuong.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quoccuong.entities.Users;
import com.quoccuong.service.JwtService;
import com.quoccuong.service.UserService;

@Controller
@RequestMapping("/rest")
public class UserRestController {
	@Autowired
	private JwtService jwtService;
	@Autowired
	private UserService userService;
	@PostMapping("/login")
	public ResponseEntity<String> login(HttpServletRequest request,@RequestBody Users user)
	{
		String result="";
		HttpStatus httpStatus=null;
		try {
			
		      if (userService.checkLogin(user)) {
		          result = jwtService.generateTokenLogin(user.getUsername());
		          httpStatus = HttpStatus.OK;
		        } else {
		          result = "Wrong userId and password";
		          httpStatus = HttpStatus.BAD_REQUEST;
		        }
		      } catch (Exception ex) {
		        result = "Server Error";
		        httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		      }
		  return new ResponseEntity<String>(result, httpStatus);
		}
}
