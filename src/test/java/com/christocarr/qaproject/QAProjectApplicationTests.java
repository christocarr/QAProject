
package com.christocarr.qaproject;

import com.christocarr.qaproject.model.Customer;
import com.christocarr.qaproject.repository.CustomerRepository;
import com.christocarr.qaproject.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;


@SpringBootTest
@RequiredArgsConstructor
public class QAProjectApplicationTests {
	private CustomerRepository customerRepository;
	private CustomerService customerService;

	@BeforeEach
	void setupService() {
		customerRepository = mock(CustomerRepository.class);
		customerService = new CustomerService(customerRepository);
	}

	@Test
	void getId() {
		int id = 2;
		Customer customer = new Customer(id, "Jack", "Black", "101 Hollywood Blvd", "", "LA", "BD20 0RR", "BJ200370K");
		Customer customerClone = new Customer(id, "Jack", "Black", "101 Hollywood Blvd", "", "LA", "BD20 0RR", "BJ200370K");
		customerRepository.save(customer);
		when(customerRepository.findById(2)).thenReturn(Optional.of(customer));

		assertThat(customer).isEqualTo(customerClone);
	}

	@Test
	void getAll() {
		List<Customer> customers = new ArrayList<>();
		customers.add(new Customer());

		given(customerRepository.findAll()).willReturn(customers);

		List<Customer> expected = customerService.getAllCustomers();
		assertEquals(expected, customers);
		verify(customerRepository).findAll();
	}

	@Test
	void getById() {
		Customer customer = new Customer(1001, "Jack", "Black", "101 Hollywood Blvd", "", "LA", "BD20 0RR", "BJ200370K");

		when(customerRepository.findById(customer.getCustomerId())).thenReturn(Optional.of(customer));

		Optional<Customer> expected = customerService.getCustomerById(customer.getCustomerId());

		assertTrue(expected.isPresent());
		assertEquals(customer, expected.get());
		verify(customerRepository).findById(customer.getCustomerId());
	}

	@Test
	public void addCustomer() {
		Customer customer = new Customer(1001, "Jack", "Black", "101 Hollywood Blvd", "", "LA", "BD20 0RR", "BJ200370K");

		when(customerRepository.save(ArgumentMatchers.any(Customer.class))).thenReturn(customer);

		Customer created = customerService.addCustomer(customer);

		assertThat(created.getFirstName()).isSameAs(customer.getFirstName());
		verify(customerRepository).save(customer);
	}

	@Test
	public void updateCustomer() {
		Customer customer = new Customer(1001, "Jack", "Black", "101 Hollywood Blvd", "", "LA", "BD20 0RR", "BJ200370K");
		Customer update = new Customer(1001, "Jackson", "Black", "101 Hollywood Blvd", "", "LA", "BD20 0RR", "BJ200370K");

		given(customerRepository.findById(customer.getCustomerId())).willReturn(Optional.of(customer));
		customerService.updateCustomer(update);

		verify(customerRepository).save(update);
		verify(customerRepository).findById(customer.getCustomerId());
	}

	@Test
	public void deleteCustomer() {
		Customer customer = new Customer(1001, "Jack", "Black", "101 Hollywood Blvd", "", "LA", "BD20 0RR", "BJ200370K");
		when(customerRepository.findById(customer.getCustomerId())).thenReturn(Optional.of(customer));

		customerService.deleteCustomer(customer);
		verify(customerRepository).delete(customer);
	}

	@Test
	void itShouldCheckIfCustomerExistsByDriversLicense() {
		String driversLicense = "BB101055";
		Customer customer = new Customer(101, "Bob", "Bar", "101 Hollywood Blvd", "", "LA", "BD20 0RR", driversLicense);
		customerRepository.save(customer);

		when(customerRepository.findByDriversLicense(driversLicense)).thenReturn(Optional.of(customer));
		
		Optional<Customer> expected = customerService.findByDriversLicense(driversLicense);

		assertTrue(expected.isPresent());
		assertEquals(customer, expected.get());
		verify(customerRepository).findByDriversLicense(driversLicense);
		
	}
	
	@Test
	void itShouldCheckIfCustomerExistsByFirstName() {
		String firstName = "Paul";
		Customer customer = new Customer(101, firstName, "Bar", "101 Hollywood Blvd", "", "LA", "BD20 0RR", "PB020608K");
		List<Customer> customers = new ArrayList<>();
		customers.add(customer);
		
		given(customerRepository.selectAllByFirstName(firstName)).willReturn(customers);
		
		List<Customer> expected = (List<Customer>) customerService.findByFirstName(firstName);
		assertEquals(expected, customers);
		verify(customerRepository).selectAllByFirstName(firstName);
	}
	
	@Test
	void itShouldCheckIfCustomerExistsByLastName() {
		String lastName = "Simon";
		Customer customer = new Customer(101, "Paul", lastName, "101 Hollywood Blvd", "", "LA", "BD20 0RR", "PB020608K");
		
		List<Customer> customers = new ArrayList<>();
		customers.add(customer);
		
		given(customerRepository.selectAllByLastName(lastName)).willReturn(customers);
		
		List<Customer> expected = (List<Customer>) customerService.findByLastName(lastName);
		assertEquals(expected, customers);
		verify(customerRepository).selectAllByLastName(lastName);
	}

	@AfterEach
	public void destroyAll() {
		customerRepository.deleteAll();
	}

}
