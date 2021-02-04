package com.lzy.springboot.thymeleafdemo.controller;

import com.lzy.springboot.thymeleafdemo.entity.Employee;
import com.lzy.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    private EmployeeController(EmployeeService employeeService){
        this.employeeService=employeeService;
    };

    // add mapping for "/list"
    @GetMapping("/list")
    public String listEmployee(Model model){

        List<Employee> employees = employeeService.findAll();

        // add to the spring model
        model.addAttribute("employees",employees);

        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){

        // create model attribute to bind form data
        Employee employee = new Employee();

        model.addAttribute("employee",employee);

        return "employees/employee-form";

    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){

        // save the employee

        employeeService.save(employee);

        // use a redirect to prevent duplicate submissions
        return "redirect:/employees/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int id, Model model){

        // get the employee from the service
        Employee employee = employeeService.findById(id);

        // set employee as a model attribute to pre-populate the form
        model.addAttribute("employee",employee);

        // send over to our form
        return "employees/employee-form";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("employeeId") int id){

        // delete the employee
        employeeService.deleteById(id);

        // redirect to /employees/list
        return "redirect:/employees/list";



    }

    @GetMapping("/search")
    public String searchForContent(@RequestParam("employeeName") String name,Model model){

        // get the employee
        List<Employee> employees = employeeService.searchBy(name);

        // add to the spring model

        model.addAttribute("employees",employees);

        // send to /employees/list

        return "/employees/list-employees";

    }
}
