package com.quoccuong.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quoccuong.dao.UserDAO;
import com.quoccuong.entities.Users;

@Service
@Transactional
public class UserService {
	@Autowired
	private UserDAO userDAO;
	public Users loadUserByUsername(final String username)
	{
		return userDAO.loadUserByUsername(username);
	}
	public boolean checkLogin(Users user)
	{
		return userDAO.checkLogin(user);
	}
}
