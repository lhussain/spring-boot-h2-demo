package io.techrank.demo.controller;

import io.techrank.demo.domain.Customer;
import io.techrank.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(value = "/customers", produces = "application/json", method=RequestMethod.POST)
    public ResponseEntity<Customer> create(@RequestBody Customer customer) {
        customerService.createOrUpdateCustomer(customer);

        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(customer);
    }

    @RequestMapping(value = "/customers", produces = "application/json", method=RequestMethod.GET)
    public ResponseEntity<List<Customer>> findAll() {
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(customerService.getAll());
    }

    @RequestMapping(value = "/customers/{id}", produces = "application/json", method=RequestMethod.GET)
    public ResponseEntity<Customer> findById(@PathVariable int id) {
        Customer customer = customerService.getCustomerById(id);

        if (customer != null) {
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(customer);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(null);
        }
    }

    @RequestMapping(value = "/customers/{id}", produces = "application/json", method=RequestMethod.DELETE)
    public ResponseEntity<String> deleteById(@PathVariable int id) {
        customerService.deleteCustomerById(id);

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body("Deleted customer with id: " + id);
    }

    @RequestMapping(value = "/customers", produces = "application/json", method=RequestMethod.PUT)
    public ResponseEntity<Customer> update(@RequestBody Customer customer) {
        customerService.createOrUpdateCustomer(customer);

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(customer);
    }
}
