package com.cbfacademy.apiassessment.employee;

public class Employee {

    // final UUID id;
    private String name;
    private String jobTitle;
    private double salary; 
    private Boolean trainingComplete;


    public Employee() {
      
    }

    public Employee(String name, String jobTitle, double salary, Boolean trainingComplete) {

        this.name = name;
        this.jobTitle = jobTitle;
        this.salary = salary;
        this.trainingComplete = trainingComplete;
       
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

    public void setJobTitle(String newJobTitle) {
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
