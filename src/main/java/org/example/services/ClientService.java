package org.example.services;

import org.example.models.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    void addClient(Client client);
    Optional<Client> getClientById(Long id);
    List<Client> getAllClients();
    void updateClient(Client client);
    void deleteClient(Long id);
    List<Client> getClientsByName(String name);
}