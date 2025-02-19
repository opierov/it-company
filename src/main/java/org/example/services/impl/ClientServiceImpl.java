package org.example.services.impl;

import org.apache.ibatis.session.SqlSession;
import org.example.mapper.ClientMapper;
import org.example.models.Client;
import org.example.services.ClientService;
import org.example.utils.MyBatisUtil;

import java.util.List;
import java.util.Optional;

public class ClientServiceImpl implements ClientService {

    private final ClientMapper clientMapper;

    public ClientServiceImpl() {
        try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
            this.clientMapper = session.getMapper(ClientMapper.class);
        }
    }

    @Override
    public void addClient(Client client) {
        try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
            clientMapper.insert(client);
            session.commit();
        }
    }

    @Override
    public Optional<Client> getClientById(Long id) {
        try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
            return clientMapper.getById(id);
        }
    }

    @Override
    public List<Client> getAllClients() {
        try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
            return clientMapper.getAll();
        }
    }

    @Override
    public void updateClient(Client client) {
        try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
            clientMapper.update(client);
            session.commit();
        }
    }

    @Override
    public void deleteClient(Long id) {
        try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
            clientMapper.delete(id);
            session.commit();
        }
    }

    @Override
    public List<Client> getClientsByName(String name) {
        try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
            return clientMapper.getByName(name);
        }
    }
}