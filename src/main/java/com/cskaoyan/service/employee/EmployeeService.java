package com.cskaoyan.service.employee;

import com.cskaoyan.domain.employee.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

    List<Employee> getEmployeeData();
}
