package com.cbfacademy.apiassessment.employee;
import org.springframework.data.repository.ListCrudRepository; 

public interface EmployeeRepository extends ListCrudRepository<Employee, Long> {
    
}
