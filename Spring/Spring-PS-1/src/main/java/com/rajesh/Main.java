package com.rajesh;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}

@Entity
@Table(name = "employee")
class Employee {

    @Id
    private int empNo;

    private String name;

    private String address;

    public Employee() {
    }
    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
@RestController
@CrossOrigin("*")
class EmployeeController {

    @Autowired
    private EmployeeRepository repository;

    @PostMapping("/save")
    public Employee saveEmployee(@RequestBody Employee employee) {

        return repository.save(employee);
    }

    @GetMapping("/all")
    public List<Employee> getAllEmployees() {

        return repository.findAll();
    }
}