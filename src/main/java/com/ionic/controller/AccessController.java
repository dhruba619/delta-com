package com.ionic.controller;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ionic.delegate.AccessControllerDelegate;
import com.ionic.model.Customer;
import com.ionic.model.Token;

@RestController
@RequestMapping("api/v1.0")
public class AccessController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AccessController.class);

    @Autowired
    AccessControllerDelegate accessControllerDelegate;

    /**
     * API to handle customer registration, returns the registered customer object.
     * @param customer
     * @return
     * @throws Exception 
     */
    @RequestMapping(path = "register", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<String> register(@RequestBody Customer customer) throws Exception {
        LOGGER.debug("Registering customer with mobile: " + customer.getMobile());
        try {
            accessControllerDelegate.registerCustomer(customer);
            LOGGER.debug("Successfully registered customer with mobile: " + customer.getMobile());
            return new ResponseEntity<String>(customer.getMobile(), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            LOGGER.error("Failed to register customer with mobile: " + customer.getMobile());
            LOGGER.error("Failed for: " + e.getMessage());
            throw e;
        }

    }

}
