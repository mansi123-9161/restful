package com.mansi.webservice.restful.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.mansi.webservice.restful.bean.UserBean;

@Component
public class UserDaoService {
	private static List<UserBean> users= new ArrayList<>();
	
	private static int userCount = 3;
	static {
		users.add(new UserBean(1,"mansi",new Date()));
		users.add(new UserBean(2,"nitin",new Date()));
		users.add(new UserBean(3,"chawla",new Date()));
	}
	
	public List<UserBean> findAll() {
		return users;
	}
	
	public UserBean saveUser(UserBean userBean) {
		if(userBean.getId() == null || userBean.getId() == 0)
			userBean.setId(++userCount);
		users.add(userBean);
		
		return userBean;
	}
	
	public UserBean findOne(int id) {
		for(UserBean user: users) {
			if(user.getId()== id)
				return user;
		}
		return null;
	}
	
	public UserBean deleteById(int id) {
		Iterator<UserBean> iterator = users.iterator();
		while(iterator.hasNext()) {
			UserBean user = iterator.next();
			if(user.getId()== id) {
				iterator.remove();
			return user;
			}
		}
		return null;
	}

}
