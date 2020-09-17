package org.queuecumbers.hotel45.persistence.persistence.controllers;

import org.queuecumbers.hotel45.persistence.model.Customer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/customers")
public class CustomerController {

    @RequestMapping(method= RequestMethod.GET)
    public List<Customer> list() {

        Customer c1 = new Customer();
        c1.setFirstName("Dani");
        c1.setLastName("Valente");
        c1.setAddress("Av Antonio Augusto de Aguiar, 126");
        c1.setEmail("ddani.daraujo@gmail.com");
        c1.setPhone("+351 93512 5220");

        Customer c2 = new Customer();
        c2.setFirstName("Carlos");
        c2.setLastName("Rocha");
        c2.setAddress("Lisboa");
        c2.setEmail("carlosrocha@gmail.com");
        c2.setPhone("+351 95214 2550");

        List<Customer> list = new ArrayList<>();
        list.add(c1);
        list.add(c2);

        return list;
    }

}
