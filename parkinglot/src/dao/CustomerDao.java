package dao;

import dto.Customer;

import java.util.HashMap;

public class CustomerDao {
    private final HashMap<Integer, Customer> customers;
    private static CustomerDao instance;

    private CustomerDao() {
        this.customers = new HashMap<>();
    }

    public static synchronized CustomerDao getInstance() {
        if (instance == null) {
            instance = new CustomerDao();
        }
        return instance;
    }

    public Customer getCustomer(Integer customerId) {
        return this.customers.get(customerId);
    }

    public void addCustomer(Integer customerId, Customer customer) {
        this.customers.put(customerId, customer);
    }

    public void updateCustomer(Integer customerId, Customer customer) {
        this.customers.put(customerId, customer);
    }

    public void removeCustomer(Integer customerId) {
        this.customers.remove(customerId);
    }
}
