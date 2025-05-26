package com.springDataJpaMapping.Mapping.controller;

import com.springDataJpaMapping.Mapping.Entities.Employee;
import com.springDataJpaMapping.Mapping.Entities.Project;
import com.springDataJpaMapping.Mapping.service.EmployeeService;
import com.springDataJpaMapping.Mapping.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/project")
public class ProjectController {

    private final ProjectService projectService;
    private final EmployeeService employeeService;

    public ProjectController(ProjectService projectService, EmployeeService employeeService) {
        this.projectService = projectService;
        this.employeeService = employeeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable Long id){
        Project projectEntity = projectService.getProjectById(id);
        return new ResponseEntity<>(projectEntity,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Project> createNewProject(@RequestBody Project project){
        Project newProject = projectService.createNewProject(project);
        return new ResponseEntity<>(newProject,HttpStatus.OK);
    }

    @PutMapping("/{project_id}/employee/{employee_id}")
    public ResponseEntity<Project> employeeAssignedToProject(
            @PathVariable Long project_id,
            @PathVariable Long employee_id)
    {
       Project updatedProject = projectService.employeeAssignedToProject(project_id,employee_id);
       return new ResponseEntity<>(updatedProject,HttpStatus.OK);

    }
}
