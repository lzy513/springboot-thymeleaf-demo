package com.lzy.springboot.thymeleafdemo.service;


import com.lzy.springboot.thymeleafdemo.dao.EmployeeRepository;
import com.lzy.springboot.thymeleafdemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository){

        this.employeeRepository=employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAllByOrderByLastNameAsc();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result = employeeRepository.findById(id);
        Employee employee = null;

        if(result.isPresent()){
            employee=result.get();
        }else{
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id - " + id);

        }
        return employee;
    }

    @Override
    public void save(Employee employee) {

        employeeRepository.save(employee);

    }

    @Override
    public void deleteById(int id) {

        employeeRepository.deleteById(id);

    }

    @Override
    public List<Employee> searchBy(String name) {
       List<Employee> employees = null;
       if(name != null && (name.trim().length()>0)){
           employees = employeeRepository.findByFirstNameContainsOrLastNameContainsAllIgnoreCase(name,name);
       }else {
           employees=findAll();
       }
       return employees;
    }
}
