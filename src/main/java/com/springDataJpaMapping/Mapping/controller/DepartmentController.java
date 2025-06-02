package com.springDataJpaMapping.Mapping.controller;

import com.springDataJpaMapping.Mapping.Entities.Department;
import com.springDataJpaMapping.Mapping.service.DepartmentService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping(path = "/department")
//@RequiredArgsConstructor
public class DepartmentController {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DepartmentController that)) return false;
        return Objects.equals(departmentService, that.departmentService);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departmentService);
    }

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/{id}")
    public Department getById(@PathVariable Long id) {
        return departmentService.getDepartmentById(id);
    }

    @PostMapping
    public Department createDepartment(@RequestBody Department department) {
        Department newDepartment = departmentService.createDepartment(department);
        return newDepartment;
    }

    @PutMapping("/{departmentId}/employee/{employeeId}")
    public Department updateDepartment(
            @PathVariable Long departmentId,
            @PathVariable Long employeeId
    ) {

        return departmentService.updateDepartment(departmentId, employeeId);

    }

    @GetMapping("/assignedDepartment/{employeeId}")
    public Department assignedDepartmentOfManager(@PathVariable Long employeeId){
        return departmentService.assignedDepartmentOfManager(employeeId);
    }

    @PutMapping("/{departmentId}/assignWorker/{employeeId}")
    private Department assignWorkerToDepartment(@PathVariable Long departmentId,@PathVariable Long employeeId){
        return departmentService.assignWorkerToDepartment(departmentId,employeeId);
    }

//    AuthenticationManager
//    SecurityFilterChain

}
