package com.cbfacademy.apiassessment.employee;

import java.util.List;
import java.util.Optional;

public interface Repository<T, ID> {

    List<Employee> findAll();

    Optional<Employee> findById(Long id);

    Employee createEmployee(Employee employee);

    Employee updateEmployee(Employee employee);

    Employee deleteEmployee(Employee employee);
    
}
