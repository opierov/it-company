package org.example.dao;

import org.example.models.Client;
import java.util.List;

public interface ClientDAO extends BaseDAO<Client> {

    List<Client> getClientsByLastName(String lastName);
    List<Client> getClientsByContactInfo(String contactInfo);
    List<Client> getClientsByFirstName(String firstName);
    int getTotalClientCount();

    void updateContactInfo(Long id, String newContactInfo);

    void deleteByContactInfo(String contactInfo);
}