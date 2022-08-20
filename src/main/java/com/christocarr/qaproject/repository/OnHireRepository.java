package com.christocarr.qaproject.repository;

import com.christocarr.qaproject.model.OnHire;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OnHireRepository extends CrudRepository<OnHire, Integer> {

}
