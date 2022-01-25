package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	StudentRepository repository;

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	TaskRepository taskRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Employee employeeA = new Employee();
		Employee employeeB = new Employee();
		List<Employee> employees = new ArrayList<>();
		employees.add(employeeA);
		employees.add(employeeB);

		Task taskA = new Task();
		Task taskB = new Task();
		List<Task> tasks = new ArrayList<>();
		tasks.add(taskA);
		tasks.add(taskB);

		employeeA.addTask(taskA);
		employeeA.addTask(taskB);
		employeeB.addTask(taskB);

		employeeRepository.delete(employeeA);
	}
}
