package com.springDataJpaMapping.Mapping.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter

public class Employee extends AuditableEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;


    @OneToOne(mappedBy = "manager")
    @JsonIgnore
    private Department managedDepartment;

    @ManyToOne
    @JoinColumn(name = "worker_department_id")
    @JsonIgnore
    private Department worker_department;

    @ManyToMany(mappedBy = "teamMember")
    private Set<Project> worksOnProject;

    public Department getWorker_department() {
        return worker_department;
    }

    public void setWorker_department(Department worker_department) {
        this.worker_department = worker_department;
    }
    public Department getManagedDepartment() {
        return managedDepartment;
    }

    public void setManagedDepartment(Department managedDepartment) {
        this.managedDepartment = managedDepartment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
