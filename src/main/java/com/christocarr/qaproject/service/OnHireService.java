package com.christocarr.qaproject.service;

import com.christocarr.qaproject.model.OnHire;
import com.christocarr.qaproject.repository.OnHireRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OnHireService {
  private OnHireRepository onHireRepository;

  public OnHireService(OnHireRepository onHireRepository) {
    this.onHireRepository = onHireRepository;
  }

  //Create
  public OnHire addOnHire(OnHire onHire) {
    return onHireRepository.save(onHire);
  }

  //Read
  public Iterable<OnHire> findAllOnHire() {
    return onHireRepository.findAll();
  }

  public Optional<OnHire> findOnHireById(int id) {
    return onHireRepository.findById(id);
  }

  //Update
  public OnHire updateOnHire(OnHire onHire) {
    onHireRepository.delete(onHire);
    return onHireRepository.save(onHire);
  }

  //Delete
  public void deleteOnHire(OnHire onHire) {
    onHireRepository.delete(onHire);
  }
}
