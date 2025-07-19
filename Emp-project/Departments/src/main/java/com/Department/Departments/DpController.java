package com.Department.Departments;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DpController {

    @Autowired
    private RestTemplate restTemplate;

    private final String backendUrl = "http://localhost:9090/em";

    // Get all employees
    @GetMapping("/Employee")
    public List<Employee> getEmployees() {
        ResponseEntity<List<Employee>> response = restTemplate.exchange(
            backendUrl,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<Employee>>() {}
        );
        return response.getBody();
    }

    // Get single employee by id
    @GetMapping("/Employee/{id}")
    public Employee getEmployee(@PathVariable Long id) {
        ResponseEntity<Employee> response = restTemplate.exchange(
            backendUrl + "/" + id,
            HttpMethod.GET,
            null,
            Employee.class
        );
        return response.getBody();
    }

    // Add new employee
    @PostMapping("/Employee")
    public String addEmployee(@RequestBody Employee employee) {
        ResponseEntity<String> response = restTemplate.postForEntity(
            backendUrl,
            employee,
            String.class
        );
        return response.getBody();
    }

    // Update employee
    @PutMapping("/Employee/{id}")
    public String updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        ResponseEntity<String> response = restTemplate.exchange(
            backendUrl + "/" + id,
            HttpMethod.PUT,
            new HttpEntity<>(employee),
            String.class
        );
        return response.getBody();
    }

    // Delete employee
    @DeleteMapping("/Employee/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        ResponseEntity<String> response = restTemplate.exchange(
            backendUrl + "/" + id,
            HttpMethod.DELETE,
            null,
            String.class
        );
        return response.getBody();
    }
}
