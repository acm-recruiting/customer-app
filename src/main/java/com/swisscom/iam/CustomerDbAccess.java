package com.swisscom.iam;

// ####################
// out of review scope
// ####################
public class CustomerDbAccess {

    // ####################
    // out of review scope
    // ####################
    public Customer findById(String custId) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Customer(custId, "Peter",
                new MailingAddress("Mainstreet", "Zurich"),
                "peter@peter.com");
    }

    // ####################
    // out of review scope
    // ####################
    public void save(Customer customer) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // ####################
    // out of review scope
    // ####################
    public void delete(Customer customer) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
