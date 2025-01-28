package org.example;

import java.util.ArrayList;
import java.util.List;

public class Project {
    private int id;
    private String name;
    private String deadline;
    private double budget;
    private String technology;
    private List<Employee> employees = new ArrayList<>();
    private List<Consultant> consultants = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
        employee.getProjects().add(this);
    }

    public List<Consultant> getConsultants() {
        return consultants;
    }

    public void setConsultants(List<Consultant> consultants) {
        this.consultants = consultants;
    }

    public void addConsultant(Consultant consultant) {
        this.consultants.add(consultant);
        consultant.getProjects().add(this);
    }
}
