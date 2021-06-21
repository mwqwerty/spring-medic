package com.am.springbootsecond.controller;

import com.am.springbootsecond.Model.Customer;
import com.am.springbootsecond.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService=customerService;
    }

    @GetMapping("/")
    public List<Customer> getCustomer(){
        return customerService.getCustomer();
    }

    @GetMapping("/check")
    @ResponseBody
    public Boolean checkCustomer(@RequestParam String name){
        return customerService.checkCustomer(name);
    }

    @PostMapping("/save")
    public String saveCustomer(@RequestBody Customer customer){
        System.out.println(customer.toString());
        return customerService.saveCustomer(customer);
    }
}
