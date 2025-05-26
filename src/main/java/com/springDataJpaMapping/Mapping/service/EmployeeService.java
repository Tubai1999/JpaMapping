package com.springDataJpaMapping.Mapping.service;

import com.springDataJpaMapping.Mapping.Entities.Employee;
import com.springDataJpaMapping.Mapping.exception.ResourceNotFoundException;
import com.springDataJpaMapping.Mapping.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
//@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee getEmployeeById(Long id){
        return employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Data not found"));
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Data not found"));
        employee.setName("updated");
        employeeRepository.save(employee);
        return employee;
    }
}
