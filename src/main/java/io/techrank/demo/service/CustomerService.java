package io.techrank.demo.service;

import io.techrank.demo.domain.Customer;
import io.techrank.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private CustomerRepository repository;

    @Autowired
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public void createOrUpdateCustomer(Customer customer) {
        repository.saveAndFlush(customer);
    }

    public List<Customer> getAll() {
        return repository.findAll();
    }

    public Customer getCustomerById(int id) {
        Optional<Customer> oCustomer = repository.findById(id);
        return oCustomer.orElse(null);
    }

    public void deleteCustomerById(int id) {
        repository.deleteById(id);
    }
}
