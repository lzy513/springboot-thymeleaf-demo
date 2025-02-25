package com.lzy.springboot.thymeleafdemo.service;



import com.lzy.springboot.thymeleafdemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> findAll();

    public Employee findById(int id);

    public void save(Employee employee);

    public void deleteById(int id);

    List<Employee> searchBy(String name);
}
