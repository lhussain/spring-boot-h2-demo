package io.techrank.demo.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class CustomerControllerGetTest {

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
                .andExpect(content().json(getExistingExpectedCustomers(), false));
    }

    private String getExistingExpectedCustomers() {

        return "[\n" +
                "  {\n" +
                "    \"id\": 1,\n" +
                "    \"organizationName\": \"Tesco\",\n" +
                "    \"firstName\": \"Jon\",\n" +
                "    \"lastName\": \"White\",\n" +
                "    \"netWorth\": 10000\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 2,\n" +
                "    \"organizationName\": \"M&S\",\n" +
                "    \"firstName\": \"Terry\",\n" +
                "    \"lastName\": \"Red\",\n" +
                "    \"netWorth\": 10000\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 3,\n" +
                "    \"organizationName\": \"British Airways\",\n" +
                "    \"firstName\": \"Mike\",\n" +
                "    \"lastName\": \"White\",\n" +
                "    \"netWorth\": 1000000\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 4,\n" +
                "    \"organizationName\": \"Google\",\n" +
                "    \"firstName\": \"Larry\",\n" +
                "    \"lastName\": \"Page\",\n" +
                "    \"netWorth\": 100000\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 5,\n" +
                "    \"organizationName\": \"Amazon\",\n" +
                "    \"firstName\": \"Jeff\",\n" +
                "    \"lastName\": \"Besoz\",\n" +
                "    \"netWorth\": 1000000\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 6,\n" +
                "    \"organizationName\": \"Microsoft\",\n" +
                "    \"firstName\": \"Bill\",\n" +
                "    \"lastName\": \"Gates\",\n" +
                "    \"netWorth\": 100000\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 7,\n" +
                "    \"organizationName\": \"Tesla\",\n" +
                "    \"firstName\": \"Elon\",\n" +
                "    \"lastName\": \"Musk\",\n" +
                "    \"netWorth\": 1000000\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 8,\n" +
                "    \"organizationName\": \"Apple\",\n" +
                "    \"firstName\": \"Tim\",\n" +
                "    \"lastName\": \"Cook\",\n" +
                "    \"netWorth\": 1000000\n" +
                "  }\n" +
                "]";
    }
}
