package com.example.demo;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employeeId")
    private Long id;

    @ManyToMany(cascade = {CascadeType.MERGE})
    @JoinTable(
            name = "employeeTask",
            joinColumns = {@JoinColumn(name = "employeeId")},
            inverseJoinColumns = {@JoinColumn(name = "taskId")}
    )
    private List<Task> tasks = new ArrayList<>();

    public void addTask(Task task){
        tasks.add(task);
        task.getEmployees().add(this);
    }

    public void removeTask(Task task){
        tasks.remove(task);
        task.getEmployees().remove(this);
    }
    public List<Task> getTasks() {
        return tasks;
    }

    @Override
    public String toString() {
        return String.format("Employee [id=%s]", id);
    }
}