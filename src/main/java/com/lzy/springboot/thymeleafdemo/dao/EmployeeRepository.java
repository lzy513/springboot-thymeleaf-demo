package com.lzy.springboot.thymeleafdemo.dao;

import com.lzy.springboot.thymeleafdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    // no need to write the code here.

    // add a method to sort by last name
    public List<Employee> findAllByOrderByLastNameAsc();
}
