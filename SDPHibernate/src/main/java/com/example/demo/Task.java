package com.example.demo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "taskId")
    private Long id;

    @ManyToMany(mappedBy = "tasks")
    private List<Employee> employees = new ArrayList<Employee>();

    public Task() {
        super();
    }

    public void addEmployee(Employee employee){
        employees.add(employee);
        employee.getTasks().add(this);
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
        employee.getTasks().remove(this);
    }

    public List<Employee> getEmployees(){
        return employees;
    }

    @Override
    public String toString() {
        return String.format("Task [id=%s]", id);
    }
}
