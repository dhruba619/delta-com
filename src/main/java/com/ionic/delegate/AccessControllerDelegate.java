package com.ionic.delegate;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ionic.model.Customer;
import com.ionic.model.Token;
import com.ionic.repository.ICustomerRepository;

@Component
public class AccessControllerDelegate {

    @Autowired
    ICustomerRepository customerRepository;

    /**
     * Method calls DAO after validating the incoming customer object.
     * @param customer
     * @return
     * @throws Exception 
     */
    public void registerCustomer(Customer customer) throws Exception {
        // TODO implement password hashing at a later stage
        // depending on how frontend sends the password.
        validateCustomer(customer);
        customerRepository.save(customer);
        sendActivationEmail(customer.getEmail());
    }


    /**
     * Method to validate the required fields of customer
     * @param customer
     * @throws Exception 
     */
    private void validateCustomer(Customer customer) throws Exception {
        
        if(null==customer.getEmail()||customer.getEmail()==""){
            throw new IllegalArgumentException("Email is required");
        }
        if(null==customer.getPassword()||customer.getPassword()==""){
            throw new IllegalArgumentException("Password is required");
        }
        if(null==customer.getMobile()||customer.getMobile()==""){
            throw new IllegalArgumentException("Mobile is required");
        }
        if (null != customerRepository.findOne(customer.getMobile())) {
            throw new Exception("Customer exists with given mobile");
        }

        if (null != customerRepository.findByEmail(customer.getEmail())) {
            throw new Exception("Customer exists with given email");
        }
    }
    
    /**
     * 
     * @param email
     */
    private void sendActivationEmail(String email){
        //TODO implement email integration
    }
}
