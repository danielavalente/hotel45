package com.hotel45;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hotel45.dao.BookingDao;
import com.hotel45.dao.CustomerDao;
import com.hotel45.dao.RoomDao;
import com.hotel45.dao.UserDao;

@SpringBootApplication
public class Hotel45Application implements CommandLineRunner {
	
	@Autowired
	private BookingDao bookingDao;
	
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private RoomDao roomDao;
	
	@Autowired
	private UserDao userDao;

	public static void main(String[] args) {
		SpringApplication.run(Hotel45Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		
	}
	
}
