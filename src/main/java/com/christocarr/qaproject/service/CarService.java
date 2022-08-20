package com.christocarr.qaproject.service;

import com.christocarr.qaproject.model.Car;
import com.christocarr.qaproject.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarService {
  private CarRepository carRepository;

  public CarService(CarRepository carRepository) {
    this.carRepository = carRepository;
  }

  //Create
  public Car addCar(Car car) {
    return carRepository.save(car);
  }

  //Read
  public Iterable<Car> getAllCars() {
    return carRepository.findAll()
;  }

  public Optional<Car> getCarById(int id) {
    return carRepository.findById(id);
  }

  //Update
  public Car updateCar(Car car) {
    carRepository.delete(car);
    return carRepository.save(car);
  }

  //Delete
  public void deleteCar(Car car) {
    carRepository.delete(car);
  }
}
