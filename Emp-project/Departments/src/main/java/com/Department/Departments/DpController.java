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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
public class DpController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/Employee")
    public List<Employee> getEmployees() {
        ResponseEntity<List<Employee>> response = restTemplate.exchange(
            "http://localhost:9090/em",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<Employee>>() {}
        );
        return response.getBody();
    }    

    @PostMapping("/Employee")
    public Employee addEmployee(@RequestBody Employee employee) {
        ResponseEntity<Employee> response = restTemplate.exchange(
            "http://localhost:9090/em",
            HttpMethod.POST,
            new HttpEntity<Employee>(employee),
            Employee.class
        );
        return response.getBody();
    }

    @GetMapping("/Employee/{id}")
    public Employee getEmployee(@PathVariable Long id) {
        ResponseEntity<Employee> response = restTemplate.exchange(
            "http://localhost:9090/em/" + id,
            HttpMethod.GET,
            null,
            Employee.class
        );
        return response.getBody();
    }

    @DeleteMapping("/Employee/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        restTemplate.exchange(
            "http://localhost:9090/em/" + id,
            HttpMethod.DELETE,
            null,
            Void.class
        );
    }

    @PutMapping("/Employee/{id}")
    public void updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        restTemplate.exchange(
            "http://localhost:9090/em/" + id,
            HttpMethod.PUT,
            new HttpEntity<Employee>(employee),
            Void.class
        );
    }

}