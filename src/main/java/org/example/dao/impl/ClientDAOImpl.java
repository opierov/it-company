/*
package org.example.dao.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.dao.ClientDAO;
import org.example.models.Client;
import org.example.models.Project;
import org.example.utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClientDAOImpl implements ClientDAO {
    private static final Logger logger = LogManager.getLogger(ClientDAOImpl.class);
    private final Connection connection;

    public ClientDAOImpl() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    // 1. Insert operation
    @Override
    public void insert(Client client) {
        String sql = "INSERT INTO clients (name, contact_info, first_name, last_name, projects_id) " +
        "VALUES (?, ?, ?, ?, ?) ";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, client.getName());
            stmt.setString(2, client.getContactInfo());
            stmt.setString(3, client.getFirstName());
            stmt.setString(4, client.getLastName());
            //stmt.setLong(5, client.getProject() != null ? client.getProjects().getId() : null);
            stmt.executeUpdate();
            logger.info("Client inserted successfully: {}", client.getName());
        } catch (SQLException e) {
            logger.error("Error inserting client", e);
        }
    }

    // 2. Select with two join statements
    @Override
    public Optional<Client> getById(Long id) {
        String sql = "SELECT c.*, p.name AS project_name, e.name AS employee_name " +
                "FROM clients c " +
                "LEFT JOIN projects p ON c.projects_id = p.id " +
                "LEFT JOIN employees e ON e.client_id = c.id " +
                "WHERE c.id = ? ";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return Optional.of(mapToClient(rs));
            }
        } catch (SQLException e) {
            logger.error("Error fetching client by ID", e);
        }
        return Optional.empty();
    }

    // 3. Five select operations
    @Override
    public List<Client> getAll() {
        List<Client> clients = new ArrayList<>();
        String sql = "SELECT c.*, p.name AS project_name " +
                "FROM clients c " +
                "LEFT JOIN projects p ON c.projects_id = p.id ";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                clients.add(mapToClient(rs));
            }
        } catch (SQLException e) {
            logger.error("Error fetching all clients", e);
        }
        return clients;
    }

    @Override
    public List<Client> getClientsByContactInfo(String contactInfo) {
        List<Client> clients = new ArrayList<>();
        String sql = "SELECT c.*, p.name AS project_name " +
                "FROM clients c LEFT JOIN projects p ON c.projects_id = p.id " +
                "WHERE c.contact_info = ? ";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, contactInfo);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                clients.add(mapToClient(rs));
            }
        } catch (SQLException e) {
            logger.error("Error fetching clients by contact info", e);
        }
        return clients;
    }

    @Override
    public List<Client> getClientsByFirstName(String firstName) {
        List<Client> clients = new ArrayList<>();
        String sql = "SELECT * FROM clients WHERE first_name = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, firstName);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                clients.add(mapToClient(rs));
            }
        } catch (SQLException e) {
            logger.error("Error fetching clients by first name", e);
        }
        return clients;
    }

    @Override
    public List<Client> getClientsByLastName(String lastName) {
        List<Client> clients = new ArrayList<>();
        String sql = "SELECT * FROM clients WHERE last_name = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, lastName);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                clients.add(mapToClient(rs));
            }
        } catch (SQLException e) {
            logger.error("Error fetching clients by last name", e);
        }
        return clients;
    }

    @Override
    public int getTotalClientCount() {
        String sql = "SELECT COUNT(*) AS total FROM clients";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) {
                return rs.getInt("total");
            }
        } catch (SQLException e) {
            logger.error("Error fetching total client count", e);
        }
        return 0;
    }

    // 4. Two Update operations
    @Override
    public void update(Client client) {
        String sql = "UPDATE clients SET name = ?, contact_info = ?, first_name = ?, last_name = ?, projects_id = ? " +
                "WHERE id = ? ";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, client.getName());
            stmt.setString(2, client.getContactInfo());
            stmt.setString(3, client.getFirstName());
            stmt.setString(4, client.getLastName());
            //stmt.setLong(5, client.getProject() != null ? client.getProject().getId() : null);
            stmt.setLong(6, client.getId());

            stmt.executeUpdate();
            logger.info("Client updated successfully: {}", client.getName());
        } catch (SQLException e) {
            logger.error("Error updating client", e);
        }
    }

    @Override
    public void updateContactInfo(Long id, String newContactInfo) {
        String sql = "UPDATE clients SET contact_info = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, newContactInfo);
            stmt.setLong(2, id);
            stmt.executeUpdate();
            logger.info("Updated contact info for client with ID: {}", id);
        } catch (SQLException e) {
            logger.error("Error updating client contact info", e);
        }
    }

    // 5. Two Delete operations
    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM clients WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
            logger.info("Client deleted successfully with ID: {}", id);
        } catch (SQLException e) {
            logger.error("Error deleting client", e);
        }
    }

    @Override
    public void deleteByContactInfo(String contactInfo) {
        String sql = "DELETE FROM clients WHERE contact_info = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, contactInfo);
            stmt.executeUpdate();
            logger.info("Deleted clients with contact info: {}", contactInfo);
        } catch (SQLException e) {
            logger.error("Error deleting client by contact info", e);
        }
    }

    private Client mapToClient(ResultSet rs) throws SQLException {
        Client client = new Client();
        client.setId(rs.getLong("id"));
        client.setName(rs.getString("name"));
        client.setContactInfo(rs.getString("contact_info"));
        client.setFirstName(rs.getString("first_name"));
        client.setLastName(rs.getString("last_name"));

        List<Project> projects = new ArrayList<>();

        do {
            long projectId = rs.getLong("projects_id");
            if (projectId != 0) {
                Project project = new Project();
                project.setId(projectId);
                project.setName(rs.getString("project_name"));
                project.setDeadline(rs.getString("project_deadline"));
                project.setBudget(rs.getDouble("project_budget"));
                project.setTechnology(rs.getString("project_technology"));
                projects.add(project);
            }
        } while (rs.next());

        client.setProjects(projects);

        return client;
    }
}
*/
