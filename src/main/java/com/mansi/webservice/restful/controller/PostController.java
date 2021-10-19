package com.mansi.webservice.restful.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mansi.webservice.restful.bean.Post;
import com.mansi.webservice.restful.bean.User;
import com.mansi.webservice.restful.exception.UserNotFoundException;
import com.mansi.webservice.restful.repository.PostRepository;
import com.mansi.webservice.restful.repository.UserRepository;

@RestController
public class PostController {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PostRepository postRepository;
	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> returnAllUsers(@PathVariable int id){
		Optional<User> users =userRepository.findById(id);
		if(!users.isPresent())
			throw new UserNotFoundException("id"+ id);
		return users.get().getPosts();
	}
	
	@PostMapping("/jpa/users/{id}/posts")
	public ResponseEntity<Object> createPost(@PathVariable int id,@RequestBody Post post) {
		
		Optional<User> user =userRepository.findById(id);
		if(!user.isPresent())
			throw new UserNotFoundException("id"+ id);
		
		User userSaved = user.get();
		post.setUser(userSaved);
		postRepository.save(post);
		URI location = ServletUriComponentsBuilder
				       .fromCurrentRequest().path("/{id}").
				       buildAndExpand(post.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}

}
