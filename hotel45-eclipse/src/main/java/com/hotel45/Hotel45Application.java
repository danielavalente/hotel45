package com.hotel45;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hotel45.dao.BookingDao;
import com.hotel45.dao.CustomerDao;
import com.hotel45.dao.RoomDao;
import com.hotel45.model.Booking;
import com.hotel45.model.Customer;
import com.hotel45.model.Room;
import com.hotel45.other.TypeOfRoom;

@SpringBootApplication
public class Hotel45Application implements CommandLineRunner {
	
	@Autowired
	private BookingDao bookingDao;
	
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private RoomDao roomDao;

	public static void main(String[] args) {
		SpringApplication.run(Hotel45Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Room room1 = new Room(TypeOfRoom.ECONOMIC, 50, true);
		Room room2 = new Room(TypeOfRoom.EXECUTIVE, 100, false);
		Room room3 = new Room(TypeOfRoom.LUXURY, 200, true);
		Room room4 = new Room(TypeOfRoom.LUXURY, 200, false);
		
		Customer customer1 = new Customer("Dani", "Valente", "Rio de Janeiro", "+351 935 125 220", "ddani.daraujo@gmail.com");
		Customer customer2 = new Customer("Carlos", "Rocha", "Lisboa", "+351 915 845 561", "carlosrocha@gmail.com");
		Customer customer3 = new Customer("Andre", "Pisco", "Madri", "+351 910 559 402", "andrepisco@gmail.com");
		Customer customer4 = new Customer("Nuno", "Pina", "Marte", "+351 910 667 502", "nunopina@gmail.com");
		Customer customer5 = new Customer("Micaela", "Moreira", "Lisboa", "+351 924 087 844", "rafa@gmail.com");
	
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Booking booking4 = new Booking(customer1, room3, sdf.parse("01/08/2020"), sdf.parse("03/09/2020"), 1000);
		Booking booking1 = new Booking(customer1, room1, sdf.parse("15/09/2020"), sdf.parse("20/09/2020"), 500);
		Booking booking2 = new Booking(customer2, room1, sdf.parse("25/09/2020"), sdf.parse("30/09/2020"), 500);
		Booking booking3 = new Booking(customer1, room2, sdf.parse("09/10/2020"), sdf.parse("10/10/2020"), 200);
		Booking booking5 = new Booking(customer5, room4, sdf.parse("11/10/2020"), sdf.parse("13/10/2020"), 100);
		
		
		room1.getBookingList().addAll(Arrays.asList(booking1, booking2));
		room2.getBookingList().addAll(Arrays.asList(booking3));
		room3.getBookingList().addAll(Arrays.asList(booking4));
		room4.getBookingList().addAll(Arrays.asList(booking5));
		
		
		customer1.getBookingList().addAll(Arrays.asList(booking1, booking3, booking4));
		customer2.getBookingList().addAll(Arrays.asList(booking2));
		customer5.getBookingList().addAll(Arrays.asList(booking5));
		
		
		roomDao.saveAll(Arrays.asList(room1, room2, room3, room4));
		customerDao.saveAll(Arrays.asList(customer1, customer2, customer3, customer4, customer5));
		bookingDao.saveAll(Arrays.asList(booking1, booking2, booking3, booking4, booking5));
		
	}
	
	
}
