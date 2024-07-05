package com.learning.service;

import com.learning.entity.Customer;
import com.learning.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Customer registerCustomer(Customer customer) {
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        return customerRepository.save(customer);
    }

    public Customer authenticateCustomer(String username, String password) {
        Customer customer = customerRepository.findByUsername(username);
        if (customer != null && passwordEncoder.matches(password, customer.getPassword())) {
            return customer;
        }
        return null;
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer updateCustomer(Long id, Customer customerDetails) {
        Customer customer = customerRepository.findById(id).orElse(null);
        if (customer != null) {
            customer.setUsername(customerDetails.getUsername());
            customer.setFullname(customerDetails.getFullname());
            if (customerDetails.getPassword() != null && !customerDetails.getPassword().isEmpty()) {
                customer.setPassword(passwordEncoder.encode(customerDetails.getPassword()));
            }
            return customerRepository.save(customer);
        }
        return null;
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}