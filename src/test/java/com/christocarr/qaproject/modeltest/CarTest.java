package com.christocarr.qaproject.modeltest;

import com.christocarr.qaproject.model.Car;
import com.christocarr.qaproject.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {
  Car car;

  @BeforeEach
  void setUp() {
    car = new Car(1, "BMW", "335e", "HY21LTA", false);
  }

  @Test
  @DisplayName("Ensure make is shown")
  void testName() {
    assertEquals("BMW", car.getMake());
  }

  @Test
  @DisplayName("Ensure returns boolean")
  void testOnHire() {
    assertEquals(false, car.isOnHire());
  }
}
