package com.swisscom.iam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerRestController {

    @Autowired
    CustomerService customerService;


    @Retryable
    @PostMapping("/deleteCustomer")
    public void deleteCustomer(@RequestParam String custId, @RequestParam boolean onlyDisable) {
        customerService.deleteClient(custId, onlyDisable);
    }
}
