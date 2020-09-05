package com.swisscom.iam;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Component
public class CustomerService {

    public void deleteClient(String custId, boolean onlyDisable) {
        if (onlyDisable) {
            CustomerDbAccess customerDbAccess = new CustomerDbAccess();
            // loads a customer by an id
            Customer customer = customerDbAccess.findById(custId);
            if (customer.getEmailAddress() != null && !customer.getEmailAddress().isEmpty()) {
                String ema = customer.getEmailAddress();
                if (ema.contains("@")) {
                    sendEmail(ema, "Customer Account", "Your customer account has been successfully disabled");
                } else
                    throw new RuntimeException("Invalid Email");
            }

            customer.setValidUntil(LocalDateTime.of(LocalDate.now(), LocalTime.MAX));

            saveCustomer(customer);
        } else {
            CustomerDbAccess customerDbAccess = new CustomerDbAccess();
            // loads a customer by an id
            Customer c = customerDbAccess.findById(custId);

            PostalService ps = new PostalService();
            ps.sendLetter(c.getMailingAddress(), "Your customer account has been successfully removed");
        }
    }

    @Transactional
    public void sendEmail(String emailAddress, String subject, String message) {
        // imagine a proper implementation
    }

    public void saveCustomer(Customer customer) {
        CustomerDbAccess customerDbAccess = new CustomerDbAccess();

        Customer byId = customerDbAccess.findById(customer.getId());

        if (!byId.equals(customer)) {
            customerDbAccess.save(customer);
        }
    }

    private void refreshCustomer() {

    }
}
