package org.example.models;

import jakarta.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "Client")
@XmlAccessorType(XmlAccessType.FIELD)
public class Client {

    @XmlElement
    private Long id;

    @XmlElement
    private String name;

    @XmlElement
    private String contactInfo;

    @XmlElement
    private String firstName;

    @XmlElement
    private String lastName;

    @XmlElementWrapper(name = "projects")
    @XmlElement(name = "Project")
    private List<Project> projects;

    public Client() {}

    public Client(Long id, String name, String contactInfo, String firstName, String lastName, List<Project> projects) {
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

    public String getContactInfo() { return contactInfo; }
    public void setContactInfo(String contactInfo) { this.contactInfo = contactInfo; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public List<Project> getProjects() { return projects; }
    public void setProjects(List<Project> projects) { this.projects = projects; }

}