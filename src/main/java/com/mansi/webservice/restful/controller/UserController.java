package com.mansi.webservice.restful.controller;

import java.net.URI;
import java.util.List;

import javax.persistence.PostLoad;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mansi.webservice.restful.bean.UserBean;
import com.mansi.webservice.restful.dao.UserDaoService;
import com.mansi.webservice.restful.exception.UserNotFoundException;

@RestController
public class UserController {
	@Autowired
	private UserDaoService userDaoService;
	//retrieve all users
	@GetMapping("/users")
	public List<UserBean> returnAllUsers(){
		return userDaoService.findAll();
	}
	//retrieve 1 user
	@GetMapping("users/{id}")
   public UserBean returnUser(@PathVariable int id) {
	   UserBean user = userDaoService.findOne(id);
	   if(user == null)
		   throw new UserNotFoundException("id+" + id);
	   return user;
   }
	
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody UserBean userBean) {
		UserBean savedUser = userDaoService.saveUser(userBean);
		
		URI location = ServletUriComponentsBuilder
				       .fromCurrentRequest().path("/{id}").
				       buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("users/{id}")
	   public void deleteUser(@PathVariable int id) {
		   UserBean user = userDaoService.deleteById(id);
		   if(user == null)
			   throw new UserNotFoundException("id+" + id);
	   }
}
