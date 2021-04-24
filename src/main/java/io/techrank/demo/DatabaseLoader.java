package io.techrank.demo;

import io.techrank.demo.domain.Customer;
import io.techrank.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private CustomerRepository repository;

    @Autowired
    public DatabaseLoader(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) {
        List<Customer> customers = createCustomers();
        populateDatabase(customers);
    }

    @Transactional
    public void populateDatabase(List<Customer> customers) {
        repository.saveAll(customers);
    }

    private List<Customer> createCustomers() {
         List<Customer> customers = new ArrayList<>();

         customers.add(Customer.builder()
                 .id(1)
                 .organizationName("Tesco")
                 .firstName("Jon")
                 .lastName("White")
                 .netWorth(10000)
                 .build());

        customers.add(Customer.builder()
                .id(2)
                .organizationName("M&S")
                .firstName("Terry")
                .lastName("Red")
                .netWorth(10000)
                .build());

        customers.add(Customer.builder()
                .id(3)
                .organizationName("British Airways")
                .firstName("Mike")
                .lastName("White")
                .netWorth(1000000)
                .build());

        customers.add(Customer.builder()
                .id(4)
                .organizationName("Google")
                .firstName("Larry")
                .lastName("Page")
                .netWorth(100000)
                .build());

        customers.add(Customer.builder()
                .id(5)
                .organizationName("Amazon")
                .firstName("Jeff")
                .lastName("Besoz")
                .netWorth(1000000)
                .build());

        customers.add(Customer.builder()
                .id(6)
                .organizationName("Microsoft")
                .firstName("Bill")
                .lastName("Gates")
                .netWorth(100000)
                .build());

        customers.add(Customer.builder()
                .id(7)
                .organizationName("Tesla")
                .firstName("Elon")
                .lastName("Musk")
                .netWorth(1000000)
                .build());

        customers.add(Customer.builder()
                .id(8)
                .organizationName("Apple")
                .firstName("Tim")
                .lastName("Cook")
                .netWorth(1000000)
                .build());

        return customers;
    }
}
