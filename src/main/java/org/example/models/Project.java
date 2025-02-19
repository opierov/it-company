package org.example.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Project {
    private Long id;
    private String name;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date deadline;

    private double budget;
    private String technology;

    public Project() {}

    public Project(Long id, String name, Date deadline, double budget, String technology) {
        this.id = id;
        this.name = name;
        this.deadline = deadline;
        this.budget = budget;
        this.technology = technology;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Date getDeadline() { return deadline; }
    public void setDeadline(Date deadline) { this.deadline = deadline; }

    public double getBudget() { return budget; }
    public void setBudget(double budget) { this.budget = budget; }

    public String getTechnology() { return technology; }
    public void setTechnology(String technology) { this.technology = technology; }

    @Override
    public String toString() {
        return "Project{id=" + id + ", name='" + name + "', deadline=" + deadline +
                ", budget=" + budget + ", technology='" + technology + "'}";
    }
}