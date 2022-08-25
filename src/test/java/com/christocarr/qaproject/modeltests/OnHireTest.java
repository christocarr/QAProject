package com.christocarr.qaproject.modeltest;

import com.christocarr.qaproject.model.Customer;
import com.christocarr.qaproject.model.OnHire;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OnHireTest {

  OnHire onHire;

  @BeforeEach
  void setUp() {
    onHire = new OnHire(1, 1, 1, 22092022, 27092022);
  }

  @Test
  @DisplayName("Ensure customerId is shown")
  void testName() {
    assertEquals(1, onHire.getCustomerId());
  }

  @Test
  @DisplayName("Ensure start date is shown")
  void testDate() {
    assertEquals(22092022, onHire.getStartDate());
  }
}
