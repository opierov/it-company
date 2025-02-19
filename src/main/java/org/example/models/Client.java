package org.example.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Client {

    private Long id;
    private String name;
    private String contactInfo;
    private String firstName;
    private String lastName;
    private Project projects;

    public Client(Long id, String name, String contactInfo, String firstName, String lastName, Project projects) {
        this.id = id;
        this.name = name;
        this.contactInfo = contactInfo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.projects = projects;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @JsonProperty("contact_info")
    public String getContactInfo() { return contactInfo; }
    public void setContactInfo(String contactInfo) { this.contactInfo = contactInfo; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public Project getProjects() { return projects; }
    public void setProjects(Project projects) { this.projects = projects; }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contactInfo='" + contactInfo + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", projects=" + projects +
                '}';
    }
}