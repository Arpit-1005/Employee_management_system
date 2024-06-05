package com.company.em_project;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class EmServiceImpl implements EmService{
    List<Employee> employees = new ArrayList<>();

    @Override
    public String createEmployee(Employee employee) {
        employees.add(employee);
        return "Employee created successfully";
        
    }

    @Override
    public List<Employee> readEmployees() {
        return employees;

    }

    @Override
    public boolean deleteEmployee(Long id) {
        Employee employeeToRemove = null;
        for (Employee employee : employees) {
             if (employee.getId().equals(id)) {
                employeeToRemove = employee;
                break;
        }
    }
    if (employeeToRemove != null) {
        employees.remove(employeeToRemove);
        return true;
    }
    return false;
    }

    @Override
    public Employee readEmployee(Long id) {
        for (Employee employee : employees) {
            if (employee.getId().equals(id)) {
                return employee;
            }
        }
        return null;
}
   
    
    @Override
    public String updateEmployee(long id, Employee newEmployee) {
        for (Employee employee : employees) {
            if (employee.getId().equals(id)) {
                employee.setName(newEmployee.getName());
                employee.setEmail(newEmployee.getEmail());
                employee.setPhone(newEmployee.getPhone());
                return "Updated successfully";
            }
        }
        return "Employee not found";
}

   /* @Override
    public Employee readDepartment(String dpname) {
        for (Employee employee : employees) {
            if (employee.getDpname().equals(dpname)) {
                return employee;
            }
        }
        return null;
    }*/
    

    
}
