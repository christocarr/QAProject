package com.christocarr.qaproject.controller;

import com.christocarr.qaproject.model.Customer;
import com.christocarr.qaproject.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CustomerController {

  private CustomerService customerService;

  public CustomerController(CustomerService customerService) {
    this.customerService = customerService;
  }

  @PostMapping("/customers/add")
  public Customer addCustomer(@RequestBody Customer customer) {

    return customerService.addCustomer(customer);
  }

  @GetMapping("/customers/all")
  public Iterable<Customer> getAllCustomers() {
    return customerService.getAllCustomers();
  }

  @GetMapping("/customers/getbyid")
  public Optional<Customer> getCustomerById(@RequestBody Customer customer) {
    return customerService.getCustomerById(customer.getCustomerId());
  }

  @PutMapping("/customers/update")
  public Optional<Customer> updateCustomer(@RequestBody Customer customer) {
    return customerService.updateCustomer(customer);
  }

  @DeleteMapping("/customers/delete")
  public void deleteCustomer(@RequestBody Customer customer) {
    customerService.deleteCustomer(customer);
  }
}
