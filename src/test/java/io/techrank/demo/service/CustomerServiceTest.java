package io.techrank.demo.service;

import io.techrank.demo.domain.Customer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;

    @Test()
    public void test_getAll_existing_customers() {
        // when
        List<Customer> customers =  customerService.getAll();

        // then
        assertNotNull(customers);
        assertEquals(8, customers.size());
        assertExistingUsers(customers);
    }

    @Test()
    public void test_getCustomerById() {
        // when
       Customer customer =  customerService.getCustomerById(1);

        // then
        assertNotNull(customer);
        assertEquals(1, customer.getId());
        assertEquals("Jon", customer.getFirstName());
        assertEquals("White", customer.getLastName());
        assertEquals("Tesco", customer.getOrganizationName());
        assertEquals(10000, customer.getNetWorth());
    }


    @Test()
    public void test_create_new_customer() {
        // given
        createNewCustomer(121);

        // when
        List<Customer> customers =  customerService.getAll();

        // then
        assertNotNull(customers);
        assertEquals(9, customers.size());
        assertExistingUsers(customers);

        assertEquals(121, customers.get(8).getId());
        assertEquals("Joe", customers.get(8).getFirstName());
        assertEquals("Bloggs", customers.get(8).getLastName());
        assertEquals("JoeBloggs", customers.get(8).getOrganizationName());
        assertEquals(100, customers.get(8).getNetWorth());
    }

    @Test()
    public void test_update_new_customer() {
        // given
        int id = 121;
        createNewCustomer(id);
        Customer customer = customerService.getCustomerById(id);
        assertEquals(121, customer.getId());
        assertEquals(100, customer.getNetWorth());

        // when
        customer = getCustomer(id, 200);
        customerService.createOrUpdateCustomer(customer);

        // then
        customer =  customerService.getCustomerById(id);
        assertEquals(121, customer.getId());
        assertEquals("Joe", customer.getFirstName());
        assertEquals("Bloggs", customer.getLastName());
        assertEquals("JoeBloggs", customer.getOrganizationName());
        assertEquals(200, customer.getNetWorth());
    }

    @Test()
    public void test_delete_new_customer() {
        // given
        int id = 1;
        Customer customer = customerService.getCustomerById(id);
        assertNotNull(customer);
        assertEquals(id, customer.getId());

        // when
        customerService.deleteCustomerById(id);

        // then
       assertNull(customerService.getCustomerById(id));
    }

    private void assertExistingUsers(List<Customer> customers) {
        assertEquals("Jon", customers.get(0).getFirstName());
        assertEquals("Terry", customers.get(1).getFirstName());
        assertEquals("Mike", customers.get(2).getFirstName());
        assertEquals("Larry", customers.get(3).getFirstName());
        assertEquals("Jeff", customers.get(4).getFirstName());
        assertEquals("Bill", customers.get(5).getFirstName());
        assertEquals("Elon", customers.get(6).getFirstName());
        assertEquals("Tim", customers.get(7).getFirstName());
    }

    private void createNewCustomer(int id) {
        Customer customer = getCustomer(id, 100);
        customerService.createOrUpdateCustomer(customer);
    }

    private Customer getCustomer(int id, int netWorth) {
        return Customer.builder()
                .id(id)
                .organizationName("JoeBloggs")
                .firstName("Joe")
                .lastName("Bloggs")
                .netWorth(netWorth)
                .build();
    }
}
