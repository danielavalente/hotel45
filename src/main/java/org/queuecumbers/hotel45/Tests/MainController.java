package org.queuecumbers.hotel45.Tests;

import org.queuecumbers.hotel45.persistence.model.Customer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/costumers")
public class MainController {

    @RequestMapping(method = RequestMethod.GET)
    public List<Customer> listCustomers() {
        List<Customer> list = new ArrayList();

        Customer c1 = new Customer();
        c1.setFirstName("Dani");
        c1.setLastName("Valente");
        c1.setAddress("Av. Antonio Augusto de Aguiar, 126");
        c1.setPhone("+351 93512 5220");
        c1.setEmail("ddani.daraujo@gmail.com");

        list.add(c1);

        return list;
    }

}
