package com.mansi.webservice.restful.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.mansi.webservice.restful.bean.User;

@Component
public class UserDaoService {
	private static List<User> users= new ArrayList<>();
	
	private static int userCount = 3;
	static {
		users.add(new User(1,"mansi",new Date()));
		users.add(new User(2,"nitin",new Date()));
		users.add(new User(3,"chawla",new Date()));
	}
	
	public List<User> findAll() {
		return users;
	}
	
	public User saveUser(User userBean) {
		if(userBean.getId() == null || userBean.getId() == 0)
			userBean.setId(++userCount);
		users.add(userBean);
		
		return userBean;
	}
	
	public User findOne(int id) {
		for(User user: users) {
			if(user.getId()== id)
				return user;
		}
		return null;
	}
	
	public User deleteById(int id) {
		Iterator<User> iterator = users.iterator();
		while(iterator.hasNext()) {
			User user = iterator.next();
			if(user.getId()== id) {
				iterator.remove();
			return user;
			}
		}
		return null;
	}

}
