package com.cskaoyan.controller.employee;

import com.cskaoyan.domain.employee.Employee;
import com.cskaoyan.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/get_data")
    @ResponseBody
    public List<Employee> getEmployeeData(){

        List<Employee> employeeData = employeeService.getEmployeeData();

        return employeeData;
    }
}
