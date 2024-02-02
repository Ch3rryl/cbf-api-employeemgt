package com.cbfacademy.apiassessment.employee;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class EmployeeController {

    public EmployeeRepository repository; 


    public EmployeeController(EmployeeRepository repository) {
        this.repository = repository;
    }

    // find all employees
    @GetMapping("/employees")
    List<Employee> findAll() {
         return repository.findAll();
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> findEmployeeById(@PathVariable UUID id) {
        Optional<Employee> employeeOptional = repository.findById(id);

        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/employees/name/{name}")
    public ResponseEntity<Employee> searchByEmployeeName(@PathVariable String name) {
        List<Employee> namedEmployee = repository.searchByEmployeeName(name);

        if (!namedEmployee.isEmpty()) {
            Employee employee = namedEmployee.get(0); // first employee if multiple
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/employees/jobtitle/{jobTitle}")
    public ResponseEntity<Employee> searchByJobtitle(@PathVariable String jobTitle) {
        List<Employee> jobTtitleSearched = repository.searchByJobTitle(jobTitle);

        if (!jobTtitleSearched.isEmpty()) {
            Employee employee = jobTtitleSearched.get(0);
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    // create / post new employee details
    @PostMapping("/employees")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
    Employee savedEmployee = repository.createEmployee(employee);
    return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
}

    // update employee details
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployeeDetails(@PathVariable UUID id, @RequestBody Employee employee) {
    Employee updatedEmployee = repository.updateEmployee(id, employee);
    return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
}

    // delete employee BY id
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable UUID id) {
    repository.deleteEmployee(id);
    return new ResponseEntity<String>("Ok", HttpStatus.OK); 
}

}
