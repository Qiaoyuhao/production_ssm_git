package com.cskaoyan.mapper.employee;

import com.cskaoyan.domain.employee.Employee;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface EmployeeMapper {
    int deleteByPrimaryKey(String empId);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(String empId);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);

    List<Employee> getEmployeeData(Employee employee);
}