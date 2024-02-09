package com.cbfacademy.apiassessment.employee;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EmployeeTest {

    String filePath = "path/to/json/data.json"; 
    JSONRepository repository = new JSONRepository(filePath);

    @Test
    @DisplayName("find employee by id - if exists")
    void findByIdTest() {
      
        String testEmployeeID = "a0aef67d-9244-4a3e-8b69-1b1e3f31ab09";
        String expectedEmployeeName = "John Doe"; 

        // do i need to repeat this filePath here
        // String filePath = "path/to/json/data.json"; 
        

        // JSONRepository repository = new JSONRepository(filePath);

        Optional<Employee> employeeOptional = repository.findById(UUID.fromString(testEmployeeID));
        String actualEmployeeName = employeeOptional.map(employee -> employee.getName()).orElse(null);
        
        assertEquals(expectedEmployeeName, actualEmployeeName);
    }


    @Test
    @DisplayName("search by name test")
    void searchByNameTest() {

        //given
        String expectedEmployeeName = "Emily Davis"; 

        List<Employee> namedEmployee = repository.searchByEmployeeName(expectedEmployeeName);
        List <String> actualEmployeeSearched = namedEmployee.stream()
        .map(employee -> employee.getName())
        .map(name -> name.toLowerCase())
        .collect(Collectors.toList());

        assertTrue(actualEmployeeSearched.contains(expectedEmployeeName.toLowerCase()));

    }

}
