package com.christocarr.qaproject.controllertests;

import com.christocarr.qaproject.controller.CustomerController;
import com.christocarr.qaproject.model.Customer;
import com.christocarr.qaproject.service.CustomerService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerTests {

  @MockBean
  CustomerService customerService;
  @Autowired
  MockMvc mockMvc;
  @Autowired
  private CustomerController customerController;

  @Test
  public void testFindAll() throws Exception {
    Customer customer = new Customer(55, "Jack", "Black", "101 Hollywood Blvd", "", "LA", "BD20 0RR", "BJ200370K");
    List<Customer> customerList = Arrays.asList(customer);

    when(customerService.getAllCustomers()).thenReturn(customerList);

    mockMvc.perform(get("/customers/all"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", Matchers.hasSize(1)))
            .andExpect(jsonPath("$[0].firstName", Matchers.is("Jack")));

  }

  @Test
  public void testPostCustomer() throws Exception {
    Customer customer = new Customer(55, "Jack", "Black", "101 Hollywood Blvd", "", "LA", "BD20 0RR", "BJ200370K");

    when(customerService.addCustomer(customer)).thenReturn(customer);

    mockMvc.perform(post("/customers/add")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\"customerId\": \"100\",\"firstName\": \"Bill\",\"lastName\": \"Gates\",\"addressOne\": \"1 MicroSoft Way\", \"addressTwo\": \"\",\"city\": \"New York\", \"postcode\": \"zz23456\",\"driversLicense\": \"BG100265\"}"))
            .andExpect(status().isOk());
  }

}
