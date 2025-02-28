package org.example.models;

public class Client {
    private Long id;
    private String name;
    private String contactInfo;
    private String firstName;
    private String lastName;
    private Project project;

    private Client(ClientBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.contactInfo = builder.contactInfo;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.project = builder.project;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Project getProject() {
        return project;
    }

    public static class ClientBuilder {
        private Long id;
        private String name;
        private String contactInfo;
        private String firstName;
        private String lastName;
        private Project project;

        public ClientBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public ClientBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public ClientBuilder setContactInfo(String contactInfo) {
            this.contactInfo = contactInfo;
            return this;
        }

        public ClientBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public ClientBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public ClientBuilder setProject(Project project) {
            this.project = project;
            return this;
        }

        public Client build() {
            return new Client(this);
        }
    }

}