
package com.christocarr.qaproject;

import com.christocarr.qaproject.model.Customer;
import com.christocarr.qaproject.repository.CustomerRepository;
import com.christocarr.qaproject.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@SpringBootTest
@RequiredArgsConstructor
public class QAProjectApplicationTests {
	private CustomerRepository customerRepository;
	private CustomerService customerService;

	@BeforeEach
	void setupService() {

		customerRepository = mock(CustomerRepository.class);
		customerService = new CustomerService(customerRepository);

		List<Customer> customers = Arrays.asList(
						new Customer(55, "Jack", "Black", "101 Hollywood Blvd", "", "LA", "BD20 0RR", "BJ200370K")
		);
		customerRepository.saveAll(customers);
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
	void itShouldCheckIfCustomerExistsByDriversLicense() {
		String driversLicense = "BB101055";
		Customer customer = new Customer(101, "Bob", "Bar", "101 Hollywood Blvd", "", "LA", "BD20 0RR", driversLicense);
		customerRepository.save(customer);

		when(customerRepository.findByDriversLicense(driversLicense)).thenReturn(Optional.of(customer));

		System.out.println(customerRepository.count());
		assertThat(customer.getDriversLicense()).isEqualTo(driversLicense);
	}

//  @Test
//  void testFindAll() {
//    List<Customer> customers = Arrays.asList(
//            new Customer(102, "Jack", "Bar", "102 Hollywood Blvd", "", "LA", "BD20 0RR", "BJ200370K"),
//            new Customer(101, "Jack", "Foo", "101 Hollywood Blvd", "", "LA", "BD20 0RR", "BJ200370K")
//    );
//
////    Iterable<Customer> allCustomers = customerRepository.saveAll(customers);
//    System.out.println(customerRepository);
////    System.out.println(customerRepository.findAll());
//  }

	@AfterEach
	public void destroyAll() {
		customerRepository.deleteAll();
	}

}
