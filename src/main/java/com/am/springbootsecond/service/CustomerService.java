package com.am.springbootsecond.service;

import com.am.springbootsecond.Model.Customer;
import com.am.springbootsecond.Repos.CustomerRepos;
import com.am.springbootsecond.exceptions.CustomerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerService {

    private final CustomerRepos customerRepos;

    @Autowired
    public CustomerService(CustomerRepos customerRepos){
        this.customerRepos=customerRepos;
    }

    public List<Customer> getCustomer(){
        return customerRepos.findAll();
    }
    public String saveCustomer(Customer customer){
        try {
            customerRepos.save(customer);
            return "Success";
        } catch (Exception e) {
            new CustomerException(e);
            return e.getLocalizedMessage();
        }
    }

    public Boolean checkCustomer(String name) {
        List<Customer> customer=customerRepos.findByUname(name);
        return customer.isEmpty();
    }
}
