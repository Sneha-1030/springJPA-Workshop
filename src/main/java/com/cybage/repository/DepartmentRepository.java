package com.cybage.repository;



import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cybage.model.Department;



public interface DepartmentRepository extends JpaRepository<Department, Long> {
  Optional<Department> findById(Long id);
  
  @Transactional
  void deleteBydeptId(long id);
}