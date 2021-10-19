package com.mansi.webservice.restful.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mansi.webservice.restful.bean.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
