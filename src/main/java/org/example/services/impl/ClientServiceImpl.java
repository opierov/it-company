package org.example.services.impl;

import org.example.dao.ClientDAO;
import org.example.dao.impl.ClientDAOImpl;
import org.example.models.Client;
import org.example.services.ClientService;

import java.util.List;
import java.util.Optional;

public class ClientServiceImpl implements ClientService {

    private final ClientDAO clientDAO;

    public ClientServiceImpl() {
        this.clientDAO = new ClientDAOImpl();
    }

    @Override
    public void add(Client client) {
        clientDAO.insert(client);
    }

    @Override
    public Optional<Client> getById(Long id) {
        return clientDAO.getById(id);
    }

    @Override
    public List<Client> getAll() {
        return clientDAO.getAll();
    }

    @Override
    public void update(Client client) {
        clientDAO.update(client);
    }

    @Override
    public void delete(Long id) {
        clientDAO.delete(id);
    }

    @Override
    public List<Client> getClientsByFirstName(String firstName) {
        return clientDAO.getClientsByFirstName(firstName);
    }

    @Override
    public List<Client> getClientsByLastName(String lastName) {
        return clientDAO.getClientsByLastName(lastName);
    }

    @Override
    public List<Client> getClientsByContactInfo(String contactInfo) {
        return clientDAO.getClientsByContactInfo(contactInfo);
    }

    @Override
    public int getTotalClientCount() {
        return clientDAO.getTotalClientCount();
    }

    @Override
    public void updateClientContactInfo(Long id, String newContactInfo) {
        clientDAO.updateContactInfo(id, newContactInfo);
    }

    @Override
    public void deleteClientByContactInfo(String contactInfo) {
        clientDAO.deleteByContactInfo(contactInfo);
    }
}