package com.cbfacademy.apiassessment.employee;

import java.util.List;
import java.util.Optional;

import com.cbfacademy.apiassessment.core.RepositoryA;


public interface EmployeeRepository extends RepositoryA<Employee, Long>  {

    List<Employee> findAll();

    Optional<Employee> findById(Long id);

    Employee createEmployee(Employee employee);

    Employee updateEmployee(Employee employee);

    void deleteEmployee(Long id);

}
