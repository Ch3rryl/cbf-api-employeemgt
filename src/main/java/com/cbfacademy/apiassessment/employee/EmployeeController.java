package com.cbfacademy.apiassessment.employee;

import java.util.List;
import java.util.Optional;

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
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeRepository repository; 


    public EmployeeController(EmployeeRepository repository) {
        this.repository = repository;
    }


// find all employees
    @GetMapping("/employees")
    List<Employee> findAll() {
    return repository.findAll();

    }
// find employee by id
//     @GetMapping("/employees/{id}")
//     Employee findEmployeebyId(@PathVariable Long id) {
//         return repository.findById(id)
//         .orElse(null);
// }

@GetMapping("/employess/{id}")
public ResponseEntity<Employee> findEmployeeById(@PathVariable Long id) {
    Optional<Employee> employeeOptional = repository.findById(id);

    if (employeeOptional.isPresent()) {
        Employee employee = employeeOptional.get();
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
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployeeDetails(@RequestBody Employee employee) {
    Employee updatedEmployee = repository.updateEmployee(employee);
    return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
}

// delete employee BY id
    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable Long id, @RequestBody Employee employee) {
    Employee deleteEmployee = repository.deleteEmployee(employee);
    return new ResponseEntity<>(deleteEmployee, HttpStatus.OK); 
}

}
