package org.example.models;

import java.util.List;

public class Employee {
    private int id;
    private String name;
    private String role;
    private double salary;
    private List<String> skills;

    public Employee() {}

    public Employee(int id, String name, String role, double salary, List<String> skills) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.salary = salary;
        this.skills = skills;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public List<String> getSkills() { return skills; }
    public void setSkills(List<String> skills) { this.skills = skills; }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', role='" + role + "', salary=" + salary + ", skills=" + skills + "}";
    }
}