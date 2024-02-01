package com.cbfacademy.apiassessment.employee;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.cbfacademy.apiassessment.core.RepositoryA;

@Repository
public interface EmployeeRepository extends RepositoryA<Employee, UUID>  {

    List<Employee> findAll();

    Optional<Employee> findById(UUID id);

    Employee createEmployee(Employee employee);

    Employee updateEmployee(UUID id, Employee employee);

    void deleteEmployee(UUID id);
    
    // List<Employee> searchByEmployeeName(String name); 

}
