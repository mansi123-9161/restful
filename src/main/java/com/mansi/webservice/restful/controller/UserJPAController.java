package com.mansi.webservice.restful.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.persistence.PostLoad;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mansi.webservice.restful.bean.User;
import com.mansi.webservice.restful.dao.UserDaoService;
import com.mansi.webservice.restful.exception.UserNotFoundException;
import com.mansi.webservice.restful.repository.UserRepository;

@RestController
public class UserJPAController {
	@Autowired
	private UserDaoService userDaoService;
	@Autowired
	private UserRepository userRepository;
	//retrieve all users
	@GetMapping("/jpa/users")
	public List<User> returnAllUsers(){
		return userRepository.findAll();
	}
	//retrieve 1 user
	@GetMapping("/jpa/users/{id}")
   public  EntityModel<Optional<User>> returnUser(@PathVariable int id) {
	   Optional<User> user = userRepository.findById(id);
	   if(user == null)
		   throw new UserNotFoundException("id+" + id);
	   EntityModel<Optional<User>> modal = EntityModel.of(user);
	   
	   //creating links
	   WebMvcLinkBuilder linkToUsers = linkTo(methodOn(this.getClass()).returnAllUsers());
	   modal.add(linkToUsers.withRel("all=-users"));
	   return modal;
   }
	
	@PostMapping("/jpa/users")
	public ResponseEntity<Object> createUser(@RequestBody User userBean) {
		User savedUser = userRepository.save(userBean);
		URI location = ServletUriComponentsBuilder
				       .fromCurrentRequest().path("/{id}").
				       buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/jpa/users/{id}")
	   public void deleteUser(@PathVariable int id) {
		    userRepository.deleteById(id);
	}
}
