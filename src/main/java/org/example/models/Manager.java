package org.example.models;


public class Manager {
    private int id;
    private String name;
    private double salary;
    private String industry;

    public Manager() {}

    public Manager(int id, String name, double salary, String industry) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.industry = industry;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public String getIndustry() { return industry; }
    public void setIndustry(String industry) { this.industry = industry; }

    @Override
    public String toString() {
        return "Manager{id=" + id + ", name='" + name + "', salary=" + salary + ", industry='" + industry + "'}";
    }
}