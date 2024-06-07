package com.company.em_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class EmController {
    
    @Autowired
    EmService emService;

    @GetMapping("/em")
    public List<Employee> getAllEmployees() {
        return emService.readEmployees();
    }
    @GetMapping("em/{id}")
    public Employee getEmployees(@PathVariable Long id) {
        return emService.readEmployee(id);
    }
    /*@GetMapping("em/{dpname}")
    public Employee getDepartments(@PathVariable String dpname) {
        return emService.readDepartment(dpname);
    }*/

    @PostMapping("em")
    public String createEmployee(@RequestBody Employee employee) {
        return emService.createEmployee(employee);
    }

    @DeleteMapping("em/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        if(emService.deleteEmployee(id))
            return "Deleted successfully";    
        return "Not found";           
    }

   @PutMapping("em/{id}")
    public String updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        return emService.updateEmployee(id, employee);
    }

}
