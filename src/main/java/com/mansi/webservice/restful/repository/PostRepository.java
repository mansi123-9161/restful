package com.mansi.webservice.restful.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mansi.webservice.restful.bean.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

}
