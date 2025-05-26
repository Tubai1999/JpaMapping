package com.springDataJpaMapping.Mapping.service;

import com.springDataJpaMapping.Mapping.Entities.Department;
import com.springDataJpaMapping.Mapping.Entities.Employee;
import com.springDataJpaMapping.Mapping.exception.ResourceNotFoundException;
import com.springDataJpaMapping.Mapping.repositories.DepartmentRepository;
import com.springDataJpaMapping.Mapping.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
//@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    public DepartmentService(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Data not found"));
    }

    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Department updateDepartment(Long departmentId, Long employeeId) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(()-> new ResourceNotFoundException("Department Data not found"));
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee data not found"));
        department.setManager(employee);
        departmentRepository.save(department);
        return department;
    }

    public Department assignedDepartmentOfManager(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(()-> new ResourceNotFoundException("employee not found"));
        return employee.getManagedDepartment();
    }

    public Department assignWorkerToDepartment(Long departmentId,Long employeeId) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(()-> new ResourceNotFoundException("Department Data not found"));
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee data not found"));
        employee.setWorker_department(department);
        employeeRepository.save(employee);
        department.getWorkers().add(employee);
        departmentRepository.save(department);
        return department;
    }
}
