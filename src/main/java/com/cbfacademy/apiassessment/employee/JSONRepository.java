package com.cbfacademy.apiassessment.employee;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Repository
@Primary
public class JSONRepository implements EmployeeRepository {
    private final String filePath;
    private final ObjectMapper objectMapper;
    private final Map<UUID, Employee> database;

    // using Jackson

    public JSONRepository(@Value("${json.file.path}") String filePath) {
        this.filePath = filePath;
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        database = loadDataFromJson();
    }

    // Exception handling - try catch on filePath - throws IOException when an input or output fails.

    // Read JSON data
    private Map<UUID, Employee> loadDataFromJson() {
        try {
            System.out.println(filePath);  // ouput: src/main/resources/data/data.json
            
            File file = new File("src/main/resources/data/data.json"); 
            
            if (file.exists()) {                
                return objectMapper.readValue(file, new TypeReference<Map<UUID, Employee>>() {
                });
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new HashMap<>();
    }

    // write JSON data
    private void saveDataToJson() {

        try {
            objectMapper.writeValue(new File(filePath), database);

        } catch (IOException e) {
            // throwable class that prints error along with exact location / class name
            e.printStackTrace();
        }
    }

    // ----------- implement methods from EmployeeRepository ----------------- //

    // find all implementation
    @Override
    public List<Employee> findAll() {
        Collection<Employee> employeeColl = database.values();
        List<Employee> employees = new ArrayList<Employee>(employeeColl);
        return (List<Employee>) employees;
    }

    // find by id implementation
    @Override
    public Optional<Employee> findById(UUID id) {
        return Optional.ofNullable(database.get(id));
    }

    // create employee implementation
    @Override
    public Employee createEmployee(Employee employee) {
        UUID id = UUID.randomUUID(); 
        database.put(id, employee);
        saveDataToJson();

        return employee;
    }

    // update employee implementation
    @Override
    public Employee updateEmployee(UUID id, Employee updatedEmployee) {
        // UUID id = updatedEmployee.getId();
        return findById(id)
                .map(existingEmployee -> {
                    existingEmployee.setName(updatedEmployee.getName());
                    existingEmployee.setJobTitle(updatedEmployee.getJobTitle());
                    existingEmployee.setSalary(updatedEmployee.getSalary());

                    saveDataToJson();
                    return existingEmployee;
                })
                .orElse(null);
    }

    // delete implementation
    @Override
    public void deleteEmployee(UUID id) {
        database.remove(id);
        saveDataToJson();
    }

    // search employee by name
    @Override
    public List<Employee> searchByEmployeeName(String name) {
        return database.values().stream()
                // .contains enables partial name search
                .filter(employee -> employee.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    // search by job title
    @Override
    public List<Employee> searchByJobTitle(String jobTitle) {
        return database.values().stream()
                // .contains enables partial search of job title
                .filter(employee -> employee.getJobTitle().toLowerCase().contains(jobTitle.toLowerCase()))
                .collect(Collectors.toList());
    }

    // explicit algorithm to find highest salary
    @Override
    public double getSalaryMax(List<Employee> employees) {
    
        double maxSalary = Double.MIN_VALUE; 

        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            double salary = employee.getSalary(); 
            if (salary > maxSalary) {
                maxSalary = salary;
            }
        }
    
        return maxSalary;
    } 
}
    