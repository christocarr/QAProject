package com.christocarr.qaproject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Customer {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column
  private int customerId;
  @Column
  private String firstName;
  @Column
  private String lastName;
  @Column
  private String addressOne;
  @Column
  @Nullable
  private String addressTwo;
  @Column
  private String city;
  @Column
  private String postcode;
  @Column
  private String driversLicense;

  @Override
  public boolean equals(Object obj) {
    if(obj == this) {
      return true;
    }
    if(obj instanceof Customer) {
      Customer customer = (Customer)obj;
      return this.customerId == customer.customerId;
    }
    return false;
  }
}
