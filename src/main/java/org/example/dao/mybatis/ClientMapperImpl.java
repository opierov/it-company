package org.example.dao.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.dao.ClientDAO;
import org.example.models.Client;
import org.example.utils.MyBatisUtil;

import java.util.List;
import java.util.Optional;

public class ClientMapperImpl implements ClientDAO {
    private static final Logger logger = LogManager.getLogger(ClientMapperImpl.class);
    private final SqlSessionFactory sqlSessionFactory;

    public ClientMapperImpl() {
        this.sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();
    }

    @Override
    public void insert(Client client) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            session.getMapper(ClientDAO.class).insert(client);
            logger.info("Client inserted successfully: {}", client.getName());
        } catch (Exception e) {
            logger.error("Error inserting client", e);
        }
    }

    @Override
    public Optional<Client> getById(Long id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.getMapper(ClientDAO.class).getById(id);
        } catch (Exception e) {
            logger.error("Error fetching client by ID", e);
            return Optional.empty();
        }
    }

    @Override
    public List<Client> getAll() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.getMapper(ClientDAO.class).getAll();
        } catch (Exception e) {
            logger.error("Error fetching all clients", e);
            return List.of();
        }
    }

    @Override
    public List<Client> getClientsByContactInfo(String contactInfo) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.getMapper(ClientDAO.class).getClientsByContactInfo(contactInfo);
        } catch (Exception e) {
            logger.error("Error fetching clients by contact info", e);
            return List.of();
        }
    }

    @Override
    public List<Client> getClientsByFirstName(String firstName) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.getMapper(ClientDAO.class).getClientsByFirstName(firstName);
        } catch (Exception e) {
            logger.error("Error fetching clients by first name", e);
            return List.of();
        }
    }

    @Override
    public List<Client> getClientsByLastName(String lastName) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.getMapper(ClientDAO.class).getClientsByLastName(lastName);
        } catch (Exception e) {
            logger.error("Error fetching clients by last name", e);
            return List.of();
        }
    }

    @Override
    public int getTotalClientCount() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.getMapper(ClientDAO.class).getTotalClientCount();
        } catch (Exception e) {
            logger.error("Error fetching total client count", e);
            return 0;
        }
    }

    @Override
    public void update(Client client) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            session.getMapper(ClientDAO.class).update(client);
            logger.info("Client updated successfully: {}", client.getName());
        } catch (Exception e) {
            logger.error("Error updating client", e);
        }
    }

    @Override
    public void updateContactInfo(Long id, String newContactInfo) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            session.getMapper(ClientDAO.class).updateContactInfo(id, newContactInfo);
            logger.info("Updated contact info for client with ID: {}", id);
        } catch (Exception e) {
            logger.error("Error updating client contact info", e);
        }
    }

    @Override
    public void delete(Long id) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            session.getMapper(ClientDAO.class).delete(id);
            logger.info("Client deleted successfully with ID: {}", id);
        } catch (Exception e) {
            logger.error("Error deleting client", e);
        }
    }

    @Override
    public void deleteByContactInfo(String contactInfo) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            session.getMapper(ClientDAO.class).deleteByContactInfo(contactInfo);
            logger.info("Deleted clients with contact info: {}", contactInfo);
        } catch (Exception e) {
            logger.error("Error deleting client by contact info", e);
        }
    }
}
