package com.springDataJpaMapping.Mapping.service;

import com.springDataJpaMapping.Mapping.Entities.Employee;
import com.springDataJpaMapping.Mapping.Entities.Project;
import com.springDataJpaMapping.Mapping.exception.ResourceNotFoundException;
import com.springDataJpaMapping.Mapping.repositories.EmployeeRepository;
import com.springDataJpaMapping.Mapping.repositories.ProjectRepository;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final EmployeeRepository employeeRepository;

    public ProjectService(ProjectRepository projectRepository, EmployeeRepository employeeRepository) {
        this.projectRepository = projectRepository;
        this.employeeRepository = employeeRepository;
    }

    public Project getProjectById(Long id) {
        return projectRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Data not found"));
    }

    public Project createNewProject(Project project) {
        return projectRepository.save(project);
    }

    public Project employeeAssignedToProject(Long projectId, Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(()->new ResourceNotFoundException("Data not found"));
        Project project = projectRepository.findById(projectId).orElseThrow(()->new ResourceNotFoundException("Data not found"));
        project.getTeamMember().add(employee);
        projectRepository.save(project);
        return project;
    }
}
