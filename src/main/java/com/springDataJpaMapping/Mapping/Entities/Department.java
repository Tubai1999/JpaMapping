package com.springDataJpaMapping.Mapping.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @OneToOne
    @JoinColumn(name = "department_manager")
    private Employee manager;

    @OneToMany(mappedBy = "worker_department")
//    @JsonIgnore
    private Set<Employee> workers;

    public Set<Employee> getWorkers() {
        return workers;
    }

    public void setWorkers(Set<Employee> workers) {
        this.workers = workers;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
