package com.springDataJpaMapping.Mapping.repositories;

import com.springDataJpaMapping.Mapping.Entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
