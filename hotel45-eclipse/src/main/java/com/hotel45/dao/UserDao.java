package com.hotel45.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel45.model.Users;

public interface UserDao extends JpaRepository<Users,Integer>{
	
	
	public Users findByUsername(String username);
	

}
