package com.cskaoyan.service.employee.impl;

import com.cskaoyan.domain.employee.Employee;
import com.cskaoyan.mapper.employee.EmployeeMapper;
import com.cskaoyan.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    @Override
    public List<Employee> getEmployeeData() {

        Employee employee = new Employee();
        List<Employee> list = employeeMapper.getEmployeeData(employee);
        return list;
    }
}
