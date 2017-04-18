package com.ionic.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ionic.model.Customer;



public interface ICustomerRepository extends CrudRepository<Customer, String> {
    
    
    @Query("SELECT c FROM Customer c WHERE c.email = :email")
    Customer findByEmail(@Param("email") String email);
}
