package com.cbfacademy.apiassessment.employee;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
    private final Map<Long, Employee> database;

    // using Jackson

    public JSONRepository(@Value("${json.file.path}") String filePath) {
        this.filePath = filePath;
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        database = loadDataFromJson();
    }

    // Exception handling - try catch on filePath - throws IOException when an input
    // or output fails.

    // Read JSON data
    private Map<Long, Employee> loadDataFromJson() {
        try {
            System.out.println(filePath);  // ouput: src/main/resources/data/data.json
            File file = new File(filePath);
            System.out.println(file.exists());  // ouput: false
            // File file = new File("src/main/resources/data/data.json");  // this works
            
            if (file.exists()) {                
                return objectMapper.readValue(file, new TypeReference<Map<Long, Employee>>() {
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
            // printstacktrace is a throwable class that prints error along with exact
            // location / class name
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
    public Optional<Employee> findById(Long id) {
        return Optional.ofNullable(database.get(id));
    }

    // create employee implementation
    @Override
    public Employee createEmployee(Employee employee) {
        database.put(employee.getId(), employee);
        saveDataToJson();

        return employee;
    }

    // update employee implementation
    @Override
    public Employee updateEmployee(Employee updatedEmployee) {
        Long id = updatedEmployee.getId();
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
    public void deleteEmployee(Long id) {
        database.remove(id);
        saveDataToJson();
    }

}

// @Override
// public String value() {
// // TODO Auto-generated method stub
// throw new UnsupportedOperationException("Unimplemented method 'value'");
// }

// @Override
// public Class<? extends Annotation> annotationType() {
// // TODO Auto-generated method stub
// throw new UnsupportedOperationException("Unimplemented method
// 'annotationType'");
// }
