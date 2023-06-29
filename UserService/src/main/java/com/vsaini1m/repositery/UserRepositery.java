package com.vsaini1m.repositery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vsaini1m.entity.User;

@Repository
public interface UserRepositery extends JpaRepository<User, String>{

}
