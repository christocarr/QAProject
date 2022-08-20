package com.christocarr.qaproject.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Car {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column
  private int carId;
  @Column
  private String make;
  @Column
  private String model;
  @Column
  private String registration;
  @Column
  private boolean onHire;
}
