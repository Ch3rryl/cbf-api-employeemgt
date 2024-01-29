package com.cbfacademy.apiassessment.employee;

public class Employee {

    private Long id; 
    private String name;
    private String jobTitle;
    private double salary; 
    private Boolean trainingComplete;

    public Employee(Long id, String name, String jobTitle, double salary, Boolean trainingComplete) {

        this.id = id;
        this.name = name;
        this.jobTitle = jobTitle;
        this.salary = salary;
        this.trainingComplete = trainingComplete;
    }



public Long getId() {
    return id;
}

public void setId(Long newId) {
    this.id = newId;
}

public String getName() {
    return name; 
}

public void setName(String newName) {
    this.name = newName;
}

public String getJobTitle() {
    return jobTitle;
}

public void setJobtitle(String newJobTitle) {
    this.jobTitle = newJobTitle; 
}

public double getSalary() {
    return salary;
}

public void setSalary(double newSalary) {
    this.salary = newSalary;
}

public boolean getTrainingComplete() {
    return trainingComplete;
}

public void setTrainingComplete(boolean newTrainingComplete) {
    this.trainingComplete = newTrainingComplete; 
}

}

// keys: name, id, job title, salary, training complete, 