package org.example.services;

import org.example.models.Client;

import java.util.List;

public interface ClientService extends Service<Client> {
    List<Client> getClientsByFirstName(String firstName);
    List<Client> getClientsByLastName(String lastName);
    List<Client> getClientsByContactInfo(String contactInfo);
    int getTotalClientCount();
    void updateClientContactInfo(Long id, String newContactInfo);
    void deleteClientByContactInfo(String contactInfo);
}