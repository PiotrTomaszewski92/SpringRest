package com.spring.controller;
import com.spring.entity.Customer;
import com.spring.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    //autowire the CustomerService - injects the dependency
    @Autowired
    private CustomerService customerService;

    //add mapping for GET /customers
    @GetMapping("/customers")
    public List<Customer> getCustomers(){
        return customerService.getCustomers();
    }

    //add mapping fot GET /customers/{customerId}
    @GetMapping("/customers/{customerId}")
    public Customer getCustomer(@PathVariable int customerId){
        Customer customer = customerService.getCustomer(customerId);
        if(customer==null)
            throw new CustomerNotFoundException("customer id not found - "+customerId);
        return customer;
    }

    //add mapping for POST /customers - add new customer
    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer customer){
        customer.setId(0);
        customerService.saveCustomer(customer);
        return customer;
    }

    //add mapping for PUT /customers - update the customer
    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer customer){
        customerService.saveCustomer(customer);
        return customer;
    }

    //add mapping .=fur DELETE /customers - delete customer
    @DeleteMapping("/customers/{customerId}")
    public String deleteCustomer(@PathVariable int customerId){
        Customer customer = customerService.getCustomer(customerId);
        if(customer == null)
            throw new CustomerNotFoundException("Customer ID not found - "+customerId);

        customerService.deleteCustomer(customerId);
        return "deleted customer id - "+customerId;
    }
}


