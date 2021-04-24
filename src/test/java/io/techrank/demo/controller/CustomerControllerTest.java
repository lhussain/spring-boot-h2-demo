package io.techrank.demo.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.hamcrest.core.Is;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CustomerControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void givenCustomers_whenGetCustomers_thenStatus200()
            throws Exception {

        mvc.perform(get("/api/customers")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id", Is.is(1)))
                .andExpect(jsonPath("$[0].firstName", Is.is("Jon")))
                .andExpect(jsonPath("$[0].lastName", Is.is("White")))
                .andExpect(jsonPath("$[0].organizationName", Is.is("Tesco")))
                .andExpect(jsonPath("$[0].netWorth", Is.is(10000)));
    }

    @Test
    public void givenCustomers_whenPostCustomer_thenStatus201()
            throws Exception {

        mvc.perform(post("/api/customers")
                .content(getCustomerRequest())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    public void givenCustomers_whenPutCustomer_thenStatus200()
            throws Exception {

        mvc.perform(put("/api/customers")
                .content(getCustomerUpdateRequest())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void givenCustomers_whenDeleteCustomer_byId_27_thenStatus200()
            throws Exception {

        mvc.perform(delete("/api/customers/127")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    private String getCustomerRequest() {
        return "{" +
                "   \"id\": 127, " +
                "   \"firstName\" : \"Joe\", " +
                "   \"lastName\" : \"Bloggs\", " +
                "   \"organizationName\" : \"JoeBloggs2\", " +
                "   \"netWorth\" : 100" +
                "}";
    }

    private String getCustomerUpdateRequest() {
        return "{" +
                "   \"id\": 127, " +
                "   \"firstName\" : \"Joe\", " +
                "   \"lastName\" : \"Bloggs\", " +
                "   \"organizationName\" : \"JoeBloggs2\", " +
                "   \"netWorth\" : 200" +
                "}";
    }
}
