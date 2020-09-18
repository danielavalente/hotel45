package com.hotel45.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hotel45.model.Customer;

@Repository
@Transactional(readOnly=true)
public interface CustomerDao extends JpaRepository<Customer, Integer> {

	@Query("SELECT customer FROM Customer customer WHERE FIRST_NAME LIKE %:searchTerm% OR LAST_NAME LIKE %:searchTerm%")
	public List<Customer> findBySearchTerm(@Param("searchTerm") String searchTerm);
	
}
