package com.christocarr.qaproject.modeltests;

import com.christocarr.qaproject.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTest {
  Customer customer;

  @BeforeEach
  void setUp() {
    customer = new Customer(1, "Jim", "Jack", "22 Java Road","", "London", "N8 0DD", "JJ230990K");
  }

  @Test
  @DisplayName("Ensure first name is show")
  void testName() {
    assertEquals("Jim", customer.getFirstName());
  }
}
