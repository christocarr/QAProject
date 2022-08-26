package com.christocarr.qaproject.repository;

import com.christocarr.qaproject.model.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

  //custom query find all by first name
  @Query("SELECT c FROM Customer c WHERE c.firstName = ?1")
  Iterable<Customer> selectAllByFirstName(String firstName);

  //custom query find by drivers license
  @Query("SELECT c FROM Customer c WHERE c.driversLicense = ?1")
  Optional<Customer> findByDriversLicense(String driversLicense);
  
//custom query find all by last name
  @Query("SELECT c FROM Customer c WHERE c.lastName = ?1")
  Iterable<Customer> selectAllByLastName(String lastName);
}
