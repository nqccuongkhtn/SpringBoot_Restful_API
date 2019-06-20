package com.quoccuong.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.quoccuong.entities.Users;

@Repository
public class UserDAO {
	@Autowired
	private SessionFactory sessionFactory;
	public Users loadUserByUsername(final String username)
	{
		Session session=sessionFactory.getCurrentSession();
		String hql="from Users where username =: username";
		Query query = session.createQuery(hql);
		query.setParameter("username", username);
		List<Users> listUs=query.getResultList();
		if(listUs!=null&&listUs.size()>0)
		{
			return listUs.get(0);
		}
		else
		{	
			return null;
		}		
	}
	
	
	public boolean checkLogin(Users userForm)
	{
		Session session=sessionFactory.getCurrentSession();
		String hql="from Users where username = :username and password = :password";
		Query query = session.createQuery(hql);
		query.setParameter("username", userForm.getUsername());
		query.setParameter("password", userForm.getPassword());
		List<Users> listUs=query.getResultList();
		if(listUs!=null&&listUs.size()>0)
		{
			return true;
		}
		else
		{	
			return false;
		}		
	}
}
