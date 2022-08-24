package com.christocarr.qaproject.controller;

import com.christocarr.qaproject.exceptions.ResourceNotFoundException;
import com.christocarr.qaproject.model.Customer;
import com.christocarr.qaproject.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CustomerController {

  private CustomerService customerService;
  private ResourceNotFoundException resourceNotFoundException;

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

  @GetMapping("/customers/{id}")
  public Optional<Customer> getCustomerById(@PathVariable int id) throws ResourceNotFoundException {
    return Optional.ofNullable(customerService.getCustomerById(id).orElseThrow(() -> new ResourceNotFoundException("Customer not found with this id.")));
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
