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
    public ResponseEntity<List<Employee>> searchByEmployeeName(@PathVariable String name) {
        List<Employee> namedEmployee = repository.searchByEmployeeName(name);

        if (!namedEmployee.isEmpty()) {
            return new ResponseEntity<>(namedEmployee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/employees/jobtitle/{jobTitle}")
    public ResponseEntity<List<Employee>> searchByJobtitle(@PathVariable String jobTitle) {
        List<Employee> jobTitleSearched = repository.searchByJobTitle(jobTitle);

        if (!jobTitleSearched.isEmpty()) {
            return new ResponseEntity<>(jobTitleSearched, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
}

    @GetMapping("/employee/salary/maxsalary") 
    public ResponseEntity<Double> getSalaryMax() {
        List<Employee> employees = repository.findAll();
            double maxSalary = repository.getSalaryMax(employees); 

        return new ResponseEntity<>(maxSalary, HttpStatus.OK);
   
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

    // delete employee by id
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable UUID id) {
    repository.deleteEmployee(id);
    return new ResponseEntity<String>("Ok", HttpStatus.OK); 
}

}
