package com.christocarr.qaproject;

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
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
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
  public void testFindById() throws Exception {
    Customer customer = new Customer(55, "Jack", "Black", "101 Hollywood Blvd", "", "LA", "BD20 0RR", "BJ200370K");

    when(customerService.getCustomerById(customer.getCustomerId())).thenReturn(Optional.of(customer));

    mockMvc.perform(get("/customers/{id}", customer.getCustomerId())
            .contentType("text/plain"))
            .andExpect(status().isOk());

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

  @Test
  public void testPutCustomer() throws Exception {
    MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
            .put("/customers/update")
            .contentType(MediaType.APPLICATION_JSON)
            .characterEncoding("UTF-8")
            .content(getCustomerJson(55));

    mockMvc.perform(builder)
            .andExpect(MockMvcResultMatchers.status().isOk());
  }

  @Test
  public void testDeleteCustomer() throws Exception {
    Customer customer = new Customer(55, "Jack", "Black", "101 Hollywood Blvd", "", "LA", "BD20 0RR", "BJ200370K");

    doNothing().when(customerService).deleteCustomer(customer);

    mockMvc.perform(delete("/customers/delete")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\"customerId\": \"55\",\"firstName\": \"Jack\",\"lastName\": \"Black\",\"addressOne\": \"101 Hollywood Blvd\", \"addressTwo\": \"\",\"city\": \"LA\", \"postcode\": \"BD20 0RR\",\"driversLicense\": \"BJ200370K\"}"))
            .andExpect(status().isOk());

  }

  private String getCustomerJson(int id) {
    return "{\"customerId\": \"" + id + "\",\"firstName\": \"Jack\",\"lastName\": \"Black\",\"addressOne\": \"101 Hollywood Blvd\", \"addressTwo\": \"\",\"city\": \"LA\", \"postcode\": \"BD20 0RR\",\"driversLicense\": \"BJ200370K\"}";
  }

}
