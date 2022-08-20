package com.christocarr.qaproject.service;

import com.christocarr.qaproject.model.Customer;
import com.christocarr.qaproject.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

  private CustomerRepository customerRepository;

  public CustomerService(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  //Create
  public Customer addCustomer(Customer customer) {
    return customerRepository.save(customer);
  }

  //Read
  public Iterable<Customer> getAllCustomers() {
    return customerRepository.findAll();
  }

  public Optional<Customer> getCustomerById(int id) {
    return customerRepository.findById(id);
  }

  //Update
  public Customer updateCustomer(Customer customer) {
    customerRepository.deleteById(customer.getCustomerId());
    return customerRepository.save(customer);
  }

  //Delete
  public void deleteCustomer(Customer customer) {
    customerRepository.delete(customer);
  }
}
