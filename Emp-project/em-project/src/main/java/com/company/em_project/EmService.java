package com.company.em_project;

import java.util.List;

import org.springframework.stereotype.Service;
@Service
public interface EmService {
    String createEmployee(Employee employee); //create employee
    List<Employee> readEmployees();  //read employees
    boolean deleteEmployee(Long id); //delete employee
    String updateEmployee(long id,Employee employee); //update employee
    Employee readEmployee(Long id);//read employee
    //Employee readDepartment(String dpname);
} 
