package com.christocarr.qaproject.service;

import com.christocarr.qaproject.model.Customer;
import com.christocarr.qaproject.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
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
  public List<Customer> getAllCustomers() {
    return (List<Customer>) customerRepository.findAll();
  }

  public Optional<Customer> getCustomerById(int id) {
    return customerRepository.findById(id);
  }

  //Update
  public Optional<Customer> updateCustomer(Customer customer) {
    return customerRepository.findById(customer.getCustomerId())
            .map(cust -> {
              cust.setFirstName(customer.getFirstName());
              cust.setLastName(customer.getLastName());
              cust.setAddressOne(customer.getAddressOne());
              cust.setAddressTwo(customer.getAddressTwo());
              cust.setCity(customer.getCity());
              cust.setPostcode(customer.getPostcode());
              cust.setDriversLicense(customer.getDriversLicense());
              return customerRepository.save(cust);
            });
  }

  //Delete
  public void deleteCustomer(Customer customer) {
    customerRepository.delete(customer);
  }

  //custom query find all by first name
  public Iterable<Customer> findByFirstName(String firstName) {
    return customerRepository.selectAllByFirstName(firstName);
  }

  //custom query find by drivers license
  public Optional<Customer> findByDriversLicense(String driversLicense) {
    return customerRepository.findByDriversLicense(driversLicense);
  }
}
