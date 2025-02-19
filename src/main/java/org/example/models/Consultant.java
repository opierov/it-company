package org.example.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Consultant {
    private Long id;
    private String firstName;
    private String lastName;
    private Double salary;
    private String industry;
    private Long managerId;

    public Consultant() {}

    public Consultant(Long id, String firstName, String lastName, Double salary, String industry, Long managerId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.industry = industry;
        this.managerId = managerId;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    @JsonProperty("first_name")
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    @JsonProperty("last_name")
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public double getSalary() { return salary; }
    public void setSalary(Double salary) { this.salary = salary; }

    public String getIndustry() { return industry; }
    public void setIndustry(String industry) { this.industry = industry; }

    @JsonProperty("manager_id")
    public Long getManagerId() { return managerId; }
    public void setManagerId(Long managerId) { this.managerId = managerId; }

    @Override
    public String toString() {
        return "Consultant{id=" + id + ", firstName='" + firstName + "', lastName='" + lastName +
                "', salary=" + salary + ", industry='" + industry + "', managerId=" + managerId + "}";
    }
}