package com.springDataJpaMapping.Mapping.repositories;

import com.springDataJpaMapping.Mapping.Entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
}
