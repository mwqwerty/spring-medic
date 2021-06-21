package com.am.springbootsecond.Repos;

import com.am.springbootsecond.Model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepos extends MongoRepository<Customer,String > {
    List<Customer> findByName(String s);

    List<Customer> findByUname(String name);
}
